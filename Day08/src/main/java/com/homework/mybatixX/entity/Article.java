package mybatixX.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName day08article
 */
@TableName(value ="day08article")
@Data
public class Article {
    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    private Integer aid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 关联栏目id
     */
    private Integer cid;
}