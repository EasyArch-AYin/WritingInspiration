package writinginspiration.controller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import writinginspiration.es.ESDao;
import writinginspiration.es.ESpojo;

import java.util.List;
class ESDaoimpl {
    @Autowired
    ESDao esDao;

    List getEmotion(String param){
        return esDao.findByEmotionLike(param);
    }
}
