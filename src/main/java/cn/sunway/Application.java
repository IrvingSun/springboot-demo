package cn.sunway;

import cn.sunway.bean.User;
import cn.sunway.config.ConfigurationBean;
import cn.sunway.config.DemoDisposableBean;
import cn.sunway.config.DemoObject;
import cn.sunway.config.MyExitCodeGenerator;
import cn.sunway.event.Call119FireEventListener;
import cn.sunway.event.FireEvent;
import cn.sunway.sentinel.TargetMethod;
import cn.sunway.thread.ThreadPoolConfigurationProperties;
import cn.sunway.thread.ThreadPoolExecutorMonitor;
import cn.sunway.thread.ThreadPoolForMonitorManager;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author sunw
 * @date 2023/2/1
 */
@RestController
//@SpringBootApplication
@SpringBootConfiguration()
@EnableAutoConfiguration
@ComponentScan(basePackages = "cn.sunway")
@EnableConfigurationProperties(ThreadPoolConfigurationProperties.class)
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
    @Autowired
    private ThreadPoolForMonitorManager threadPoolForMonitorManager;
    @Autowired
    private TargetMethod targetMethod;


    private final String poolName = "first-monitor-thread-pool";


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
                demoObject.getTip() + " | " + demoObject.getName() + "<br> Object地址：" + demoObject) + "<br>" + configurationBean
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

        if (applicationContext instanceof AnnotationConfigApplicationContext) {
            System.out.println("applicationContext instanceof AnnotationConfigApplicationContext");
        } else if (applicationContext instanceof AnnotationConfigServletWebServerApplicationContext) {
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
        intiFlowRules();

    }

    @GetMapping("/manager")
    public String doManager(){
        ThreadPoolExecutorMonitor monitor = threadPoolForMonitorManager.getThreadPoolExecutor(poolName);
        for(int i = 0; i < 100; i++){
            monitor.execute(() ->{
                try {
                    Thread.sleep(new Random().nextInt(4000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return "success";
    }

    @RequestMapping("/limit")
    String limit() {
        while (true){
            targetMethod.findUserName(String.valueOf(System.currentTimeMillis()));
        }
    }

    private static void intiFlowRules() {
        List<FlowRule> rules = new ArrayList();
        FlowRule rule = new FlowRule();
        rule.setResource("findUserName");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
