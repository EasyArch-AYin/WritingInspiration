package writinginspiration.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import writinginspiration.dao.ArticleDao;
import writinginspiration.dao.EmotionDao;
import writinginspiration.es.ESDao;
import writinginspiration.es.ESpojo;
import writinginspiration.pojo.Article;
import writinginspiration.pojo.Emotion;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
@RestController
public class EmotionDaoimpl {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    EmotionDao emotionDao;

    @Autowired
    ESDao esDao;

    @PostMapping("/emotion")
//        获取传来json中的emotion
    public String getemotion(@RequestBody String json) throws UnsupportedEncodingException {
//        ESDaoimpl esDaoimpl = new ESDaoimpl();
        //        新创建一个List用于存放查询到的e_id
        List EIDList = new ArrayList();;
//        将传来的json按等号分割成数组，0是emotion，1是unicode编码
        String[] emotionLIST = json.split("=");
//        得到对应的emotion
        String emotion= URLDecoder.decode(emotionLIST[1],"utf-8");

//        将从ES中查询到的emotion词加入到List中
//        List EmotionList = new ArrayList(esDao.findByEmotionLike(emotion));
//        List EmotionList = esDaoimpl.getEmotion(emotion);
//        对每一个EmotionList中的字都在数据库中查询
        for (ESpojo eSpojo : esDao.findByEmotionLike(emotion)) {


//        从数据库中得到emotion对应的e_id
            Emotion E_ID = emotionDao.gete_id(eSpojo.getEmotion());
            if (E_ID != null) {
//        将可以匹配到的e_id存到List中
                int EID = E_ID.getE_id();
                EIDList.add(EID);
            }
        }

//        return EIDList;
        return articleDao.getTitle((Integer) EIDList.get(0)).getTitle();
    }
}
