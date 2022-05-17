package jp.te4a.spring.boot.myapp4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "this is Spring Boot sample.";
    }
}
