package writinginspiration.es;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESDao extends ElasticsearchRepository <ESpojo,String>{
     List<ESpojo> findByEmotionLike(String emotion);
}
