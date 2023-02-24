package cn.sunway;

import cn.sunway.bean.User;
import cn.sunway.config.ConfigurationBean;
import cn.sunway.config.DemoDisposableBean;
import cn.sunway.config.DemoObject;
import cn.sunway.config.MyExitCodeGenerator;
import cn.sunway.event.Call119FireEventListener;
import cn.sunway.event.FireEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
    private DemoDisposableBean demoBean;
    @Autowired
    private ConfigurationBean configurationBean;
    @Autowired
    private MyExitCodeGenerator myExitCodeGenerator;
    @Autowired
    private ConfigurableApplicationContext context;

    @RequestMapping("/")
    String home() {
//         context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
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

        return "Hello! Home page <br>" + (Objects.isNull(demoObject) ? "未加载字符串" :
                demoObject.getTip() + " | " + demoObject.getName() +"<br> Object地址：" + demoObject) + "<br>" + configurationBean
                ;
    }

    @RequestMapping("/exit")
    public void exit() {
        if (context != null) {
            System.exit(SpringApplication.exit(context, myExitCodeGenerator));
            System.out.println("SpringBoot exit success");
        } else {
            System.out.println("ConfigurableApplicationContext is null");
        }
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setBannerMode(Banner.Mode.OFF); //关闭banner
        ConfigurableApplicationContext applicationContext = application.run(args);
        application.setWebApplicationType(WebApplicationType.SERVLET);

        if(applicationContext instanceof AnnotationConfigApplicationContext){
            System.out.println("applicationContext instanceof AnnotationConfigApplicationContext");
        }else if(applicationContext instanceof AnnotationConfigServletWebServerApplicationContext){
            System.out.println("applicationContext instanceof AnnotationConfigServletWebServerApplicationContext");
        }
        AnnotationConfigServletWebServerApplicationContext webServerApplicationContext = (AnnotationConfigServletWebServerApplicationContext) applicationContext;

        System.out.println("configurableWebServerApplicationContext =====>" + webServerApplicationContext);
//        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
        try {
            User user = applicationContext.getBean(User.class);
            System.out.println("++++++>User对象为：" + user);
        } catch (Exception e) {
            System.err.println("获取User对象失败");
        }
//
//        webServerApplicationContext.register(Call119FireEventListener.class);
//        webServerApplicationContext.refresh();
        applicationContext.publishEvent(new FireEvent("ABC"));
        webServerApplicationContext.publishEvent(new FireEvent("XXX"));

        System.out.println(applicationContext == WebApplicationContextUtils.getWebApplicationContext(webServerApplicationContext.getServletContext()));

    }
}
