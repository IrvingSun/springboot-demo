package cn.sunway.config;

import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author sunw
 * @date 2023/2/9
 */
public class MyExceptionReporter implements SpringBootExceptionReporter {

    private ConfigurableApplicationContext context;

    public MyExceptionReporter(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public boolean reportException(Throwable failure) {
        System.out.println("--->||||||||||||||<---");
        failure.printStackTrace();
        return false;
    }
}
