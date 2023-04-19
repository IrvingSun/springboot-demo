package cn.sunway.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * @author sunw
 * @date 2023/4/19
 */
@Component
public class ThreadPoolForMonitorManager {
    @Autowired
    private ThreadPoolConfigurationProperties configurationProperties;

    private final ConcurrentMap<String, ThreadPoolExecutorMonitor> monitorConcurrentMap
            = new ConcurrentHashMap();

    @PostConstruct
    public void init(){
        configurationProperties.getExecutors().forEach(threadPoolProperties -> {
            if(!this.monitorConcurrentMap.containsKey(threadPoolProperties.getPoolName())){
                ThreadPoolExecutorMonitor threadPoolExecutor = new ThreadPoolExecutorMonitor(
                        threadPoolProperties.getCorePoolSize(),
                        threadPoolProperties.getMaxpoolSize(),
                        threadPoolProperties.getKeepAlive(),
                        threadPoolProperties.getUnit(),
                        new LinkedBlockingQueue<>(threadPoolProperties.getQueueCapacity()),
                        threadPoolProperties.getPoolName());
                monitorConcurrentMap.put(threadPoolProperties.getPoolName(), threadPoolExecutor);
            }
        });
    }

    public ThreadPoolExecutorMonitor getThreadPoolExecutor(String poolName){
        ThreadPoolExecutorMonitor executorMonitor = monitorConcurrentMap.get(poolName);
        if(executorMonitor == null){
            throw new RuntimeException("找不到名字为"+poolName+"的线程池");
        }
        return executorMonitor;
    }

    public ConcurrentMap<String, ThreadPoolExecutorMonitor> getMonitorConcurrentMap() {
        return monitorConcurrentMap;
    }
}
