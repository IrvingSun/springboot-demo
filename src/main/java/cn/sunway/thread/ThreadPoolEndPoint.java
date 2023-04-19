package cn.sunway.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunw
 * @date 2023/4/19
 */
@Configuration
@Endpoint(id = "threadpool")
public class ThreadPoolEndPoint {
    @Autowired
    private ThreadPoolForMonitorManager threadPoolForMonitorManager;

    @ReadOperation
    public Map<String, Object> threadPoolsMertic() {
        Map<String, Object> merticMap = new HashMap<>();
        List<Map> threadPools = new ArrayList<>();

        threadPoolForMonitorManager.getMonitorConcurrentMap().forEach((k, v) -> {
            ThreadPoolExecutorMonitor tpe = v;
            Map<String, Object> poolInfo = new HashMap<>();
            poolInfo.put("threadPool.name", k);
            poolInfo.put("threadPool.core.size", tpe.getCorePoolSize());
            poolInfo.put("threadPool.largest.size", tpe.getLargestPoolSize());
            poolInfo.put("threadPool.max.size", tpe.getMaximumPoolSize());
            poolInfo.put("threadPool.thread.count", tpe.getPoolSize());
            poolInfo.put("threadPool.max.costTime", tpe.getMaxCostTime());
            poolInfo.put("threadPool.min.costTime", tpe.getMinCostTime());
            poolInfo.put("threadPool.avg.costTime", tpe.getAvgCostTime());
            poolInfo.put("threadPool.active.count", tpe.getActiveCount());
            poolInfo.put("threadPool.complete.count", tpe.getCompletedTaskCount());
            poolInfo.put("threadPool.queue.name", tpe.getQueue().getClass().getName());
            poolInfo.put("threadPool.rejected.name", tpe.getRejectedExecutionHandler().getClass().getName());
            poolInfo.put("threadPool.task.count", tpe.getTaskCount());
            threadPools.add(poolInfo);

        });
        merticMap.put("threadPools", threadPools);
        return merticMap;
    }
}
