//package cn.sunway.spi;
//
//import org.apache.dubbo.common.extension.ExtensionLoader;
//
//public class Log$Adaptive implements cn.sunway.spi.Log {
//    public void log(java.lang.String arg0) {
//        throw new UnsupportedOperationException("The method public abstract void cn.sunway.spi.Log.log(java.lang.String) of interface cn.sunway.spi.Log is not adaptive method!");
//    }
//
//    public void info(org.apache.dubbo.common.URL arg0) {
//        if (arg0 == null) throw new IllegalArgumentException("url == null");
//        org.apache.dubbo.common.URL url = arg0;
//        String extName = url.getParameter("log", "logback");
//        if (extName == null)
//            throw new IllegalStateException("Failed to get extension (cn.sunway.spi.Log) name from url (" + url.toString() + ") use keys([log])");
//        cn.sunway.spi.Log extension = (cn.sunway.spi.Log) ExtensionLoader.getExtensionLoader(cn.sunway.spi.Log.class).getExtension(extName);
//        extension.info(arg0);
//    }
//}