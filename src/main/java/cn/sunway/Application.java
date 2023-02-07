package cn.sunway;

import cn.sunway.config.DemoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author sunw
 * @date 2023/2/1
 */
@RestController
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.sunway")
public class Application {

    @Autowired(required = false)
    private DemoObject demoObject;

    @RequestMapping("/")
    String home(){
        return "Hello! Home page \n" + (Objects.isNull(demoObject) ? "未加载字符串" : demoObject.getTip());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println();
    }

}
