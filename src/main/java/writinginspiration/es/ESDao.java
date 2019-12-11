package writinginspiration.es;


import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ESDao extends ElasticsearchRepository <ESpojo,String>{
     List<ESpojo> findByEmotionLike(String emotion);
}
