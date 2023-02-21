package cn.sunway.beanFactoryPostProcessor;

import cn.sunway.factoryBean.DemoFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class DemoBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("---------->" + configurableListableBeanFactory.getBean(DemoFactoryBean.class));
    }
}
