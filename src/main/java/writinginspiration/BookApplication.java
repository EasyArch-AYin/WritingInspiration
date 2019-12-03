package writinginspiration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {
//        new SpringApplicationBuilder(BookApplication.class).web(true).run(args);
        SpringApplication.run(BookApplication.class,args);
    }
}
