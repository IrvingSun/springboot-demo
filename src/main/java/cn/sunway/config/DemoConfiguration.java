package cn.sunway.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 当某些情况下才去加载当前类创建对象
 *
 * @author sunw
 * @date 2023/2/7
 */
@Configuration
@ConditionalOnProperty(name = "demo.object.enable",havingValue = "true")
public class DemoConfiguration {

    @Bean
    public DemoObject demoString(){
        DemoObject obj = new DemoObject();
        obj.setTip("【自动加载的字符串】");
        return obj;
    }
}
