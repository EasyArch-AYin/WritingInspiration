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
import java.util.HashSet;
import java.util.List;
@RestController
public class EmotionDaoimpl {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    EmotionDao emotionDao;

    @Autowired
    ESDao esDao;

    @PostMapping("/data")
//        获取传来index页面传来的词语json
    public Object getData(@RequestBody String json) throws UnsupportedEncodingException {


//        创建data对象存储要返回的数据
        Data data = new Data();
//        新创建一个List用于存放查询到的相关的情感
        List<String> EmotionListF = new ArrayList();
        List<Integer> EIDList = new ArrayList<>();
        List<String> TitleList = new ArrayList<>();


//        将传来的json按等号分割成数组，0是emotion，1是unicode编码
        String[] emotionLIST = json.split("=");
//        将emotion词语解码得到汉字的emotion
        String emotion = URLDecoder.decode(emotionLIST[1], "utf-8");
//        将得到的emotion词语分割成单个字
        String[] WordList = emotion.split("");


//      对每个字都进行ES查询得到所有相关的情感词语
        for (String emotionParam : WordList) {
            for (ESpojo espojo : esDao.findByEmotionLike(emotionParam)) {
                EmotionListF.add(espojo.getEmotion());
            }
        }


//        去除掉EmotionList中重复的情感
        List<String> EmotionList = new ArrayList<>(new HashSet<>(EmotionListF));


//        从数据库中得到emotion对应的e_id
        for (String empojo : EmotionList){
            Emotion E_ID = emotionDao.gete_id(empojo);
            if (E_ID != null) {
//        将可以匹配到的e_id存到List中
                int EID = E_ID.getE_id();
                EIDList.add(EID);
            }
        }

//        根据得到的E_ID查询对应的文章
        for (int EIDpojo : EIDList){
            Article Title = articleDao.getTitle(EIDpojo);
            TitleList.add(Title.getTitle());
        }

//        将数据存到data中
        data.setEmotions(EmotionList);
        data.setContent(TitleList);

        return JSON.toJSON(data);
    }
}
