package cn.sunway.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author sunw
 * @date 2023/2/22
 */
//@ConditionalOnClass({PrinterInterceptor.class})
@Configuration
public class PrinterConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自己的拦截器并设置拦截的请求路径
        registry.addInterceptor(printerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @ConditionalOnMissingBean
    @Bean
    public PrinterInterceptor printerInterceptor() {
        return new PrinterInterceptor();
    }
}
