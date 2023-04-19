package cn.sunway.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/4/19
 */
public class ThreadPoolProperties {
    private String poolName;
    private int corePoolSize;
    private int maxpoolSize = Runtime.getRuntime().availableProcessors();
    private int keepAlive = 60;
    private TimeUnit unit = TimeUnit.SECONDS;
    private int queueCapacity = Integer.MAX_VALUE;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxpoolSize() {
        return maxpoolSize;
    }

    public void setMaxpoolSize(int maxpoolSize) {
        this.maxpoolSize = maxpoolSize;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
