package cn.sunway.java8;

/**
 * @author sunw
 * @date 2023/2/24
 */
public class BasicMath implements IMath {
    @Override
    public int add(int a, int b) {
        desc();
        IMath.version();
        return a + b;
    }
}
