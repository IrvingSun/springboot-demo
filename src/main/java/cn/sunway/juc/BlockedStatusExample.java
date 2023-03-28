package cn.sunway.juc;

/**
 * @author sunw
 * @date 2023/3/28
 */
public class BlockedStatusExample implements Runnable{
    @Override
    public void run() {
        synchronized (BlockedStatusExample.class){
            while (true){

            }
        }
    }

    /**
     * 在竞争synchronized锁的时候，拿不到monitor锁，线程会进入BLOCKED状态
     * BLOCKED-2  java.lang.Thread.State: BLOCKED (on object monitor)
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new BlockedStatusExample(),"BLOCKED-1").start();
        new Thread(new BlockedStatusExample(),"BLOCKED-2").start();
    }
}
