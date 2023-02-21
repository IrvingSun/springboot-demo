package cn.sunway.beanPostProcessor;

import cn.sunway.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author sunw
 * @date 2023/2/20
 */
public class DemoBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof User){
            User user = ((User) bean);
           user.setDesc("修改过的DESC");
           return user;
        }
        return bean;
    }
}
