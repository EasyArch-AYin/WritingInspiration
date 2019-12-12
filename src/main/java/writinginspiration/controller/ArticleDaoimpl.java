package writinginspiration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import writinginspiration.dao.ArticleDao;
import writinginspiration.pojo.Article;

import java.util.List;

@RestController
public class ArticleDaoimpl {
    @Autowired
    ArticleDao articleDao;
//    对应侧边栏点击的情感进入网页（待修改）
    @PostMapping(value = "/title")
    public Article getcontent(@RequestBody List list){
//        EmotionDaoimpl emotionDaoimpl = new EmotionDaoimpl();
//        根据EIDList中的e_id查询文章的标题
//        String title = articleDao.getTitle((Integer) emotionDaoimpl.EIDList.get(1));
        return articleDao.getTitle((Integer) list.get(1));
    }
}
