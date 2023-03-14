package cn.sunway.dynamicProxy;

/**
 * @author sunw
 * @date 2023/3/15
 */
public class HelloImpl implements Hello{
    @Override
    public void sayHello() {
        System.out.println("say Hello");
    }
}
