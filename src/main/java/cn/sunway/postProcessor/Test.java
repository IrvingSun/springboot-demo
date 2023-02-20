package cn.sunway.postProcessor;

import cn.sunway.bean.User;
import cn.sunway.importSelector.DemoImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 通过BeanPostProcessor暴露出来的接口，修改bean的属性值
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
        configApplicationContext.register(DemoBeanPostProcessor.class);
        configApplicationContext.refresh();
        System.out.println("获取到 User =>" + configApplicationContext.getBean(User.class));
    }
}
