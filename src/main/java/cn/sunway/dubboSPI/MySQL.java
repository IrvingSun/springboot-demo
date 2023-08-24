package cn.sunway.dubboSPI;

/**
 * @author sunw
 * @date 2023/8/24
 */
public class MySQL implements JDBC{

    @Override
    public void info(String inf) {
        System.out.println("MySQL - " + inf);
    }
}
