package cn.sunway;

import cn.sunway.config.ConfigurationBean;
import cn.sunway.config.DemoApplicationListener;
import cn.sunway.config.DemoBean;
import cn.sunway.config.DemoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
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

    @Autowired
    private DemoBean demoBean;
    @Autowired
    private ConfigurationBean configurationBean;

    @RequestMapping("/")
    String home(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
//        context.getBeanDefinitionNames();
//        DemoConfiguration demoConfiguration = context.getBean(DemoConfiguration.class);
//
//        /**
//         * 使用proxyBeanMethods=false的时候，以下三个对象不一样
//         */
//        InnerDemoObject innerDemoObject = demoConfiguration.demoString().getInnerDemoObject();
//
//        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());
//        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());
//        System.out.println("----->"+demoConfiguration.demoString().getInnerDemoObject());

        System.out.println(demoBean.toString());

        return "Hello! Home page <br>" + (Objects.isNull(demoObject) ? "未加载字符串" : demoObject.getTip() + "<br> Object地址：" +demoObject) +"<br>" + configurationBean;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
//        application.setBannerMode(Banner.Mode.OFF); //关闭banner
        application.run(args);
        application.setWebApplicationType(WebApplicationType.SERVLET);

    }

}
