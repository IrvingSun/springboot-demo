package cn.sunway;

import cn.sunway.config.DemoConfiguration;
import cn.sunway.config.DemoObject;
import cn.sunway.config.InnerDemoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        DemoConfiguration demoConfiguration = context.getBean(DemoConfiguration.class);

        /**
         * 使用proxyBeanMethods=false的时候，以下三个对象不一样
         */
        InnerDemoObject innerDemoObject = demoConfiguration.demoString().getInnerDemoObject();

        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());
        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());
        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());

        return "Hello! Home page \n" + (Objects.isNull(demoObject) ? "未加载字符串" : demoObject.getTip() + "Object地址："+demoObject);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
