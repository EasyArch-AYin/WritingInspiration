package writinginspiration.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import writinginspiration.pojo.Article;

import java.util.List;
//制定这是一个操作数据库的mapper
@Repository
@Mapper
public interface ArticleDao {
    @Select("select title from article where e_id=#{e_id}")
    public String getTitle(int e_id);
}
