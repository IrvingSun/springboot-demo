package cn.sunway.dubboSPI;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 通过自定义的ClassLoader来获取配置的实现
 * @author sunw
 * @date 2023/8/24
 */
public class TestSPI {
    public static void main(String[] args) {
        ExtensionLoader<JDBC> extensionLoader = ExtensionLoader.getExtensionLoader(JDBC.class);
        JDBC mysql = extensionLoader.getExtension("mysql");
        JDBC oracle = extensionLoader.getExtension("oracle");

        mysql.info("-connect");
        oracle.info("-connect");
    }
}
