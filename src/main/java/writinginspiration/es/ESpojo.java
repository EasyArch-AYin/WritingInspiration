package writinginspiration.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Data
@Document(indexName = "writinginspiration",type = "emotion",
        useServerConfiguration = true,createIndex = false)
public class ESpojo {
    @Id
    private int id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String emotion;
}
