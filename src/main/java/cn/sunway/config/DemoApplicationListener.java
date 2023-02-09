package cn.sunway.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author sunw
 * @date 2023/2/8
 */
@Component
public class DemoApplicationListener implements ApplicationListener<SpringApplicationEvent> {
    @Override
    public void onApplicationEvent(SpringApplicationEvent event) {
        System.out.println(event.getClass().getName());
        if(event instanceof ApplicationStartedEvent){
            System.out.println("---->SpringBoot启动了");
        }
        else if(event instanceof ApplicationReadyEvent){
            System.out.println("---->SpringBoot就绪了");
        }
    }
}
