package cn.sunway.spi;

import org.apache.dubbo.common.URL;

/**
 * @author sunw
 * @date 2023/8/18
 */
public class Log4J implements Log{
    @Override
    public void log(String msg) {
        System.out.println("[Log4j] - " + msg);
    }

    @Override
    public void info(URL url) {
        System.out.println("[Log4j] - info");
    }
}
