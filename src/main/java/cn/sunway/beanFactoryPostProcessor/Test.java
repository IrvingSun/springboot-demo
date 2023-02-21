package cn.sunway.beanFactoryPostProcessor;

import cn.sunway.beanPostProcessor.DemoBeanPostProcessor;
import cn.sunway.factoryBean.DemoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author sunw
 * @date 2023/2/20
 */
public class Test {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(DemoFactoryBean.class);
        configApplicationContext.register(DemoBeanFactoryProcessor.class);
        configApplicationContext.refresh();
        System.out.println("获取到 DemoFactoryBean =>" + configApplicationContext.getBean(DemoFactoryBean.class));
        System.out.println("获取到 DemoFactoryBean.getObject =>" + configApplicationContext.getBean(DemoFactoryBean.class).getObject());
    }
}
