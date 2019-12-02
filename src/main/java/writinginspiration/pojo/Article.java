package writinginspiration.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
//用这个注解才能实现动态更新（update_time的更新）
@DynamicUpdate
@Data
@Table(name = "article")
public class Article {
    @Id
    private int id;
    private String title;
    private String content;
    private int e_id;
    private Timestamp create_Time;
    private Timestamp update_Time;
}
