package cn.sunway.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author sunw
 * @date 2023/4/12
 */
public class CounDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable runnable1 = () -> {
            System.out.println(Thread.currentThread().getName() + "正在准备");
            try {
                Long time = 1000L;
                System.out.println(Thread.currentThread().getName() + "需要 " + time +" ms");
                Thread.sleep(time);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "准备好了");
        };


        Runnable runnable2 = () -> {
            System.out.println(Thread.currentThread().getName() + "正在准备");
            try {
                Long time = 2000L;
                System.out.println(Thread.currentThread().getName() + "需要 " + time +" ms");
                Thread.sleep(time);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "准备好了");
        };


        Runnable runnable3 = () -> {
            System.out.println(Thread.currentThread().getName() + "正在准备");
            try {
                Long time = 3000L;
                System.out.println(Thread.currentThread().getName() + "需要 " + time +" ms");
                Thread.sleep(time);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "准备好了");
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable3);

        t1.start();
        t2.start();
//        t3.start();


        countDownLatch.await();

        System.out.println("=====");
    }
}
