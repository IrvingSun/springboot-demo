package cn.sunway.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/3/28
 */
public class TimedWaitingExample {
    public static void main(String[] args) {
        /**
         * 使用jstack $pid 查看线程状态：java.lang.Thread.State: TIMED_WAITING (sleeping)
         */
//        new Thread(() -> {
//            try {
//                TimeUnit.DAYS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "Time-Waiting").start();

        /**
         * 使用jstack $pid 查看线程状态：java.lang.Thread.State: WAITING (on object monitor)
         */
        new Thread(() -> {
            synchronized (TimedWaitingExample.class){
                try {
                    TimedWaitingExample.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Waiting").start();
    }
}
