package cn.sunway.importSelector;

import cn.sunway.bean.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过使用 ImportBeanDefinitionRegistrar 来注入beanDefinition
 *
 * @author sunw
 * @date 2023/2/20
 */
public class DemoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(User.class)
                .addPropertyValue("username", "ImportBeanDefinitionRegistrar[用户名]")
                .addPropertyValue("age",19)
                .addPropertyValue("desc","描述").getBeanDefinition();
        System.out.println("===>往容器中注入beanDefinition");
        registry.registerBeanDefinition("user", beanDefinition);
    }
}
