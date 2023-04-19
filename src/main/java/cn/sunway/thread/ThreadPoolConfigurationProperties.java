package cn.sunway.thread;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunw
 * @date 2023/4/19
 */
@ConfigurationProperties(prefix = "monitor.threadpool")
public class ThreadPoolConfigurationProperties {
    private List<ThreadPoolProperties> executors = new ArrayList<>();

    public List<ThreadPoolProperties> getExecutors() {
        return executors;
    }

    public void setExecutors(List<ThreadPoolProperties> executors) {
        this.executors = executors;
    }
}
