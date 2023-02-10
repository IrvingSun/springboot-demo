package cn.sunway.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 在服务启动之后，运行功能
 * @author sunw
 * @date 2023/2/9
 */
@Component
public class DemoRunner implements ApplicationRunner, CommandLineRunner{

    private ConfigurableApplicationContext context;

    public DemoRunner(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DemoRunner-ApplicationRunner 被调用");
        DemoObject demoObject = context.getBean("demoString",DemoObject.class);
        System.out.println("context ===>" + demoObject.getTip());
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DemoRunner-CommandLineRunner 被调用");
    }
}
