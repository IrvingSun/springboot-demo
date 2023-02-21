package cn.sunway.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class EmergencyFireEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof FireEvent)
            System.out.println("----->急救");
        else {
            System.out.println("----->不能识别的事件：" + event);
        }
    }

}
