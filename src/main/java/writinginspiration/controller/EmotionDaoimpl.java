package writinginspiration.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import writinginspiration.dao.EmotionDao;
import writinginspiration.pojo.Emotion;

import java.util.List;
import java.util.Map;

public class EmotionDaoimpl {

    @Autowired
    EmotionDao emotionDao;

//        新创建一个List用于存放查询到的e_id
    List EIDList = null;

    @RequestMapping("/emotion")
    public void getemotion(@RequestBody String json){
        ESDaoimpl esDaoimpl = new ESDaoimpl();
//        获取传来json中的emotion
        Map<String,String> map = (Map<String,String>) JSON.parse(json);
        String emotion=map.get("emotion");
//        将从ES中查询到的emotion词加入到List中
        List EmotionList = esDaoimpl.getEmotion(emotion);
//        得到emotion词的个数
        int ESIZE = EmotionList.size();
        for (int i = 0;i<ESIZE;i++){
//        从数据库中得到emotion对应的e_id
            Emotion E_ID = emotionDao.gete_id((String) EmotionList.get(i));
            if (E_ID!=null){
//        将可以匹配到的e_id存到List中
                EIDList.add(E_ID);
            }
        }
    }
}
