package cn.sunway.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author sunw
 * @date 2023/8/18
 */
@SPI("logback")
public interface Log {

    void log(String msg);

    @Adaptive("loadbalance")
    void info(URL url);

}
