package cn.sunway.spi;

import org.apache.dubbo.common.URL;

/**
 * @author sunw
 * @date 2023/8/21
 */
public class LogWrapper implements Log{

    private Log log;

    public LogWrapper(Log log) {
        this.log = log;
    }

    @Override
    public void log(String msg) {
        System.out.println("包装-start");
        log.log(msg);
        System.out.println("包装-end");
    }

    @Override
    public void info(URL url) {
        System.out.println("包装-start");
        log.info(url);
        System.out.println("包装-end");
    }
}
