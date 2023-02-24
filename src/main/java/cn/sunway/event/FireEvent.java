package cn.sunway.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author sunw
 * @date 2023/2/21
 */
public class FireEvent extends ApplicationEvent{
    public FireEvent(Object source) {
        super(source);
        System.out.println("着火了！- " + source);
    }
}
