package cn.sunway.dubboSPIIoC;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author sunw
 * @date 2023/8/24
 */
@SPI("mysql")
public interface JDBC {
    @Adaptive("dbType")
    void info(URL inf);

    @Adaptive("descType")
    void desc(URL msg);
}
