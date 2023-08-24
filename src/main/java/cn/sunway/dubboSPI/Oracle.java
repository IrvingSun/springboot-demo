package cn.sunway.dubboSPI;

/**
 * @author sunw
 * @date 2023/8/24
 */
public class Oracle implements JDBC{
    @Override
    public void info(String inf) {
        System.out.println("Oracle - " + inf);
    }
}
