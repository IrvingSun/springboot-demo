package cn.sunway.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;


public class ExtensionLoaderTest {

  @Test
  public void testGetExtensionLoader() {
    // 首先创建一个模拟用的URL对象
    URL url = URL.valueOf("dubbo://192.168.0.101:20880?loadbalance=logback");
//    Log log = ExtensionLoader.getExtensionLoader(Log.class)
//      .getAdaptiveExtension();
        Log log = ExtensionLoader.getExtensionLoader(Log.class).getExtension("log4J");

     log.info(url);
//     log.log("---msg---");
  }
}