package com.homework;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/banner")
public class BannerController {

    //多行 ASCII：gap 控制行与行之间的额外空白行数（默认 0）
    @RequestMapping(
            value = "/ascii",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> toAscii(
            @RequestParam String text,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "1") int scale,
            @RequestParam(defaultValue = "100") int threshold,
            @RequestParam(defaultValue = "0") int gap
    ) throws IOException {

        String normalized = text.replace("\\n", "\n");
        String[] lines = normalized.split("\\s*\\n\\s*|\\s+");

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;
            out.append(generateAsciiLine(line, size, scale, threshold));
            //只在两段字符画之间按需插空行
            if (i < lines.length - 1) {
                for (int k = 0; k < gap; k++) out.append('\n');
            }
        }
        return ResponseEntity.ok(out.toString());
    }

    @RequestMapping(
            value = "/ascii/save",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> toAsciiAndSave(
            @RequestParam String text,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "1") int scale,
            @RequestParam(defaultValue = "100") int threshold,
            @RequestParam(defaultValue = "0") int gap
    ) throws IOException {
        String ascii = toAscii(text, size, scale, threshold, gap).getBody();
        File file = new File("src/main/resources/banner.txt");
        file.getParentFile().mkdirs();
        try (Writer w = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            w.write(ascii);
        }
        return ResponseEntity.ok("已写入：" + file.getAbsolutePath());
    }

    //生成单行的 ASCII，并自动裁掉上下黑边
    private String generateAsciiLine(String text, int size, int scale, int threshold) {
        Font font = loadFont(size);

        //量测文本
        BufferedImage probe = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graphics2D pg = probe.createGraphics();
        pg.setFont(font);
        FontRenderContext frc = pg.getFontRenderContext();
        int textW = (int) Math.ceil(font.getStringBounds(text, frc).getWidth());
        int textH = (int) Math.ceil(font.getStringBounds(text, frc).getHeight());
        int ascent = pg.getFontMetrics(font).getAscent();
        pg.dispose();

        int imgW = Math.max(textW + 2, 2);
        int imgH = Math.max(ascent + pg.getFontMetrics(font).getDescent(), 2);

        //黑底白字
        BufferedImage img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, imgW, imgH);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawString(text, 1, Math.min(ascent, imgH - 1));
        g.dispose();

        //横向缩放
        if (scale > 1) {
            int wScaled = imgW * scale;
            BufferedImage scaled = new BufferedImage(wScaled, imgH, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = scaled.createGraphics();
            gs.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            gs.drawImage(img, 0, 0, wScaled, imgH, null);
            gs.dispose();
            img = scaled;
        }

        //裁掉上下黑边，缩小行距
        int top = 0, bottom = img.getHeight() - 1;
        //找到顶部第一行亮点
        outerTop:
        for (; top < img.getHeight(); top++) {
            for (int x = 0; x < img.getWidth(); x++) {
                if (isBright(img.getRGB(x, top), threshold)) break outerTop;
            }
        }
        //找到底部最后一行亮点
        outerBottom:
        for (; bottom >= top; bottom--) {
            for (int x = 0; x < img.getWidth(); x++) {
                if (isBright(img.getRGB(x, bottom), threshold)) break outerBottom;
            }
        }

        StringBuilder sb = new StringBuilder((bottom - top + 1) * (img.getWidth() + 1));
        for (int y = top; y <= bottom; y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                sb.append(isBright(img.getRGB(x, y), threshold) ? '*' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private boolean isBright(int rgb, int threshold) {
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        int gray = (int) (0.299 * r + 0.587 * g + 0.114 * b);
        return gray > threshold;
    }

    private Font loadFont(float size) {
        //用系统字体；其他ttf，可从resources/fonts加载
        Font f = new Font("Microsoft YaHei", Font.BOLD, (int) size);
        if (f == null || "Dialog".equals(f.getFamily())) {
            f = new Font("SansSerif", Font.BOLD, (int) size);
        }
        return f.deriveFont(Font.PLAIN, size);
    }
}
