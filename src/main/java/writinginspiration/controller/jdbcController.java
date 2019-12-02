package writinginspiration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class jdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/get")
    public Map<String,Object> getbookArticleId(){
        String sql = "select 'id' from article";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        return list.get(0);
    }
}
