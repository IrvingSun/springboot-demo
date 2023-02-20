package cn.sunway.factoryBean;

import cn.sunway.bean.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * 实现FactoryBean，将作为一个object的工厂来暴露，而不是直接将这个bean暴露出去
 * 一般用于框架中，平时使用比较少。
 * 一般使用场景：我们创建的某个object比较复杂，就需要一个实现FactoryBean接口的bean作为object的工厂注册到spring中
 *
 * Mybatis整合Spring的时候，就是通过FactoryBean来实现的，
 * 这也就是为什么在Spring的bean中可以注入MyBatis的Mapper接口动态代理的原因
 *
 *
 * @author sunw
 * @date 2023/2/20
 */
public class DemoFactoryBean implements FactoryBean<User>{
    @Nullable
    @Override
    public User getObject() throws Exception {
        System.out.println("====>调用FactoryBean创建对象");
        return new User();
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
