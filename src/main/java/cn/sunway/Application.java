package cn.sunway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunw
 * @date 2023/2/1
 */
@RestController
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.sunway")
public class Application {

    @RequestMapping("/")
    String home(){
        return "Hello! Home page";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
