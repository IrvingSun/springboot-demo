package cn.sunway.juc;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author sunw
 * @date 2023/3/29
 */
public class ClassLayoutExample {
    private int id;
    private String name = "1234567890-=";

    public static void main(String[] args) {
        ClassLayoutExample example = new ClassLayoutExample();
        System.out.println("加锁之前=========");
        System.out.println(ClassLayout.parseInstance(example).toPrintable());


        synchronized (example){
            System.out.println("加锁之后=========");
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
    }
}
//00000001
//11010000
//00000101
//-XX:BiasedLockingStartupDelay=4