package cn.sunway.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class Call119FireEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof FireEvent)
            System.out.println("----->拨打119");
        else {
            System.out.println("----->不能识别的事件：" + event);
        }
    }

}
