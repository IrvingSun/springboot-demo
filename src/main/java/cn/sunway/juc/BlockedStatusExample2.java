package cn.sunway.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/3/28
 */
public class BlockedStatusExample2 {

    public static void main(String[] args){

        Thread t1 = new Thread(() -> {
            synchronized (BlockedStatusExample2.class){
                try {
                    System.out.println("Thread-1 - wait");
                    BlockedStatusExample2.class.wait();
                    System.out.println("Thread-1 - notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-1");

        Thread t2 = new Thread(() -> {
            synchronized (BlockedStatusExample2.class){
                try {
                    System.out.println("Thread-2 - wait");
                    BlockedStatusExample2.class.wait();
                    System.out.println("Thread-2 - notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-2");

        Thread t3 = new Thread(() -> {
            synchronized (BlockedStatusExample2.class){
                try {
                    System.out.println("Thread-3 - wait");
                    BlockedStatusExample2.class.wait();
                    System.out.println("Thread-3 - notify, 此时Thread-3的状态 = " + Thread.currentThread().getState());
                    System.out.println("Thread-3 持有锁，不释放");
                    while (true){

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread-3");

        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait之后，T1 STATE = " + t1.getState());
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait之后，T2 STATE = " + t2.getState());
        t3.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait之后，T3 STATE = " + t3.getState());

        System.out.println("主线程等待1s");
        synchronized (BlockedStatusExample2.class){
            System.out.println("主线程获取到锁，notifyAll");
            BlockedStatusExample2.class.notifyAll();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("T1 STATE = " + t1.getState());
        System.out.println("T2 STATE = " + t2.getState());
        System.out.println("T3 STATE = " + t3.getState());
    }

}
