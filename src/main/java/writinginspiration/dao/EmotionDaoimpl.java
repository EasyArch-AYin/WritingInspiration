package writinginspiration.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import writinginspiration.pojo.Emotion;

public class EmotionDaoimpl {

    @Autowired
    EmotionDao emotionDao;

    @RequestMapping("/msg/{context}")
    public Emotion gete_idimpl(@PathVariable("context") int context){
        return emotionDao.gete_id(context);
    }
}
