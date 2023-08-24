package cn.sunway.spi;

import java.util.ServiceLoader;

/**
 * @author sunw
 * @date 2023/8/18
 */
public class LogMain {
    public static void main(String[] args) {
        ServiceLoader<Log> serviceLoader = ServiceLoader.load(Log.class);
        for (Log log : serviceLoader) {
            log.log("SPI 日志");
        }
    }
}
