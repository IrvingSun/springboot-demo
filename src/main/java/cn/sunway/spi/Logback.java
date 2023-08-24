package cn.sunway.spi;

import org.apache.dubbo.common.URL;

/**
 * @author sunw
 * @date 2023/8/18
 */
public class Logback implements Log{

    private Log log;

    public Logback(Log log) {
        this.log = log;
    }

    @Override
    public void log(String msg) {
        System.out.println("[Logback] - " + msg);
    }

    @Override
    public void info(URL url) {
        log.info(url);
        System.out.println("[Logback] - info - ");
    }
}
