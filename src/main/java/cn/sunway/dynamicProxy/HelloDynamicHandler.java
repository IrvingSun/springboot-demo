package cn.sunway.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunw
 * @date 2023/3/15
 */
public class HelloDynamicHandler implements InvocationHandler{
    private Object target;

    public HelloDynamicHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke: " + method.getName());
        return method.invoke(target, args);
    }
}
