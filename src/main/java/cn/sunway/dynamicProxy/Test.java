package cn.sunway.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author sunw
 * @date 2023/3/15
 */
public class Test {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        HelloDynamicHandler dynamicHandler = new HelloDynamicHandler(hello);
        Hello proxy = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), dynamicHandler);
        proxy.sayHello();
    }
}
