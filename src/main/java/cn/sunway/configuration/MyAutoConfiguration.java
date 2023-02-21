package cn.sunway.configuration;

import cn.sunway.factoryBean.DemoFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunw
 * @date 2023/2/21
 */
@Configuration

public class MyAutoConfiguration {

    @Bean
    @ConditionalOnExpression("false")
    public DemoFactoryBean demoFactoryBean(){
        return new DemoFactoryBean();
    }
}
