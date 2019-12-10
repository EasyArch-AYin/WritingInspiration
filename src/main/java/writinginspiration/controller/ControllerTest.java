package writinginspiration.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@RestController
public class ControllerTest {

    @PostMapping("/test")
    public Object getJSON(@RequestBody String json) throws UnsupportedEncodingException {
        String emotionLIST[] = json.split("=");
        String emotion= URLDecoder.decode(emotionLIST[1],"utf-8");
        return emotion;
    }
}
