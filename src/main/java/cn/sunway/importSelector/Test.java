package cn.sunway.importSelector;

import cn.sunway.bean.User;
import cn.sunway.factoryBean.DemoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 *
 * @author sunw
 * @date 2023/2/20
 */
//@Import(DemoImportSelector.class)
@Import({DemoImportBeanDefinitionRegistrar.class})
public class Test {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(Test.class);
        configApplicationContext.refresh();
        System.out.println("获取到 User =>" + configApplicationContext.getBean(User.class));
    }
}
