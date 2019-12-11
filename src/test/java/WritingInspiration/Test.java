package WritingInspiration;

//import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import writinginspiration.es.ESDao;
import writinginspiration.es.ESpojo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    DataSource dataSource;

    @Autowired
    ESDao esDao;

    @org.junit.Test
    public void test(){
        for (ESpojo espojo : esDao.findByEmotionLike("挑")) {
            System.out.println(espojo.getEmotion());
        }
    }

    @org.junit.Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
