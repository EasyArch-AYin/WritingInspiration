package writinginspiration.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import writinginspiration.dao.EmotionDao;
import writinginspiration.pojo.Emotion;

import java.util.Map;

public class EmotionDaoimpl {

    @Autowired
    EmotionDao emotionDao;

    @RequestMapping(value = "/emotion")
    public String gete_idimpl(@RequestBody String json){
        Map<String,String> map = (Map<String,String>) JSON.parse(json);
        return map.get("emotion");
    }
}
