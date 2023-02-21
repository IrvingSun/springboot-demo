package cn.sunway.event;

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
        configApplicationContext.register(Call119FireEventListener.class);
        configApplicationContext.refresh();
        configApplicationContext.publishEvent(new FireEvent("DDDD!!!!!!"));
    }
}
