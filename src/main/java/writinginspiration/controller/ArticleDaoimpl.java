package writinginspiration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import writinginspiration.dao.ArticleDao;

public class ArticleDaoimpl {
    @Autowired
    ArticleDao articleDao;
//    对应侧边栏点击的情感进入网页（待修改）
    @GetMapping(value = "/title")
    public String getcontent(){
        EmotionDaoimpl emotionDaoimpl = new EmotionDaoimpl();
//        根据EIDList中的e_id查询文章的标题
        String title = articleDao.getTitle((Integer) emotionDaoimpl.EIDList.get(1));
        return title;
    }
}
