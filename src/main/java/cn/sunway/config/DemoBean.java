package cn.sunway.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author sunw
 * @date 2023/2/13
 */
@Component
public class DemoBean implements DisposableBean{

    public DemoBean(){
        System.out.println("DemoBean ===> 初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DemoBean ===> 销毁 DisposableBean");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("DemoBean ===> 销毁 preDestory");
    }
}
