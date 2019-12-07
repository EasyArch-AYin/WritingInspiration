package writinginspiration.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import writinginspiration.pojo.Article;
import writinginspiration.pojo.Emotion;

import java.util.List;
@Repository
@Mapper
public interface EmotionDao {
        @Select("select * where e_id = #{context}")
//        Emotion emotion(@Param("context")String context);
        Emotion gete_id(int context);
}
