package writinginspiration.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.persistence.Id;

@Data
@Document(indexName = "writinginspiration",type = "emotion")
public class ESpojo {
    private int id;
    private String emotion;
}
