package cn.sunway.dubboSPIIoC;

import org.apache.dubbo.common.URL;

/**
 * @author sunw
 * @date 2023/8/24
 */
public class Oracle implements JDBC {
    @Override
    public void info(URL inf) {
        System.out.println("Oracle - Active");
    }

    @Override
    public void desc(URL msg) {
        System.out.println("Oracle - desc");
    }
}
