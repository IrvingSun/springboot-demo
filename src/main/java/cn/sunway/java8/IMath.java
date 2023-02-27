package cn.sunway.java8;

/**
 * 函数式
 * @author sunw
 * @date 2023/2/24
 */
@FunctionalInterface
public interface IMath {
    default void desc() {
        System.out.println("这是一个计算器接口....");
    }

    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);

    static void version() {
        System.out.println("当前版本 V1.1.2 ....");
    }

}
