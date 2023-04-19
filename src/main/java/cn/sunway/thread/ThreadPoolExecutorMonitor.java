package cn.sunway.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sunw
 * @date 2023/4/18
 */
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {
    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    private static final String defaultPoolName = "Default-Task";

    private static ThreadFactory threadFactory = new MonitorThreadFactory(defaultPoolName);

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new MonitorThreadFactory(poolName), defaultHandler);
    }

    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }


    private long minCostTime;
    private long maxCostTime;
    private AtomicLong totalCostTime = new AtomicLong();
    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimeThreadLocal.set(System.currentTimeMillis());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        long costTime = System.currentTimeMillis() - startTimeThreadLocal.get();
        startTimeThreadLocal.remove();
        maxCostTime = Math.max(maxCostTime, costTime);
        if (getCompletedTaskCount() == 0) {
            minCostTime = costTime;
        }
        minCostTime = Math.min(minCostTime, costTime);
        totalCostTime.addAndGet(costTime);

        super.afterExecute(r, t);
    }

    public long getAvgCostTime() {
        if (getCompletedTaskCount() == 0 || totalCostTime.get() == 0L) {
            return 0;
        }
        return totalCostTime.get() / getCompletedTaskCount();
    }

    public long getMinCostTime() {
        return minCostTime;
    }

    public long getMaxCostTime() {
        return maxCostTime;
    }

    public AtomicLong getTotalCostTime() {
        return totalCostTime;
    }
}
