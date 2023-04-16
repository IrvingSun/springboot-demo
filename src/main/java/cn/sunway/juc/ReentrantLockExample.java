package cn.sunway.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过加锁，处理并发原子操作
 * @author sunw
 * @date 2023/3/31
 */
public class ReentrantLockExample {
    static Lock lock = new ReentrantLock();
    private static int count = 0;
    private void incr(){
        lock.lock();
        count ++;
        lock.unlock();
    }
    static int printCount = 0;

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        Thread[] threads = new Thread[2];
        for(int j = 0; j < 2; j++){
            threads[j] = new Thread(() ->{
                for(int k = 0; k < 1000; k ++){
                    reentrantLockExample.incr();
                }
            });
            threads[j].start();
        }
        threads[0].join();
        threads[1].join();

        System.out.println(count);

//        Thread t1 = new Thread(() -> {
//            while(true){
//                System.out.println(printCount++);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();

//        Thread.sleep(2000);
//
//        LockSupport.park(t1);
//
//        Thread.sleep(5000);
//
//        LockSupport.unpark(t1);

    }

}
