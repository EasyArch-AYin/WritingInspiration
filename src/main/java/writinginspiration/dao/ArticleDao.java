package writinginspiration.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import writinginspiration.pojo.Article;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {
    @Select("select title,context from article")
    List<Article> searchAll();
}
