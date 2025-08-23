package mybatixX.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatixX.entity.Article;
import mybatixX.service.ArticleService;
import mybatixX.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author 37223
* @description 针对表【day08article】的数据库操作Service实现
* @createDate 2025-08-23 16:17:08
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




