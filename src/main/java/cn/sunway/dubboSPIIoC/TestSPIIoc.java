package cn.sunway.dubboSPIIoC;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author sunw
 * @date 2023/8/24
 */
public class TestSPIIoc {
    public static void main(String[] args)throws Exception {
        ExtensionLoader<JDBC> extensionLoader = ExtensionLoader.getExtensionLoader(JDBC.class);
        JDBC jdbc = extensionLoader.getAdaptiveExtension();
        jdbc.info(URL.valueOf("http://xxxxx?dbType=mysql&descType=oracle"));
        jdbc.desc(URL.valueOf("http://xxxxx?dbType=mysql&descType=oracle"));
    }
}
