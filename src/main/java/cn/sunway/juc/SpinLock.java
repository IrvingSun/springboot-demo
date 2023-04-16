package cn.sunway.juc;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自旋锁
 * @author sunw
 * @date 2023/4/3
 */
public class SpinLock {

    static AtomicReference<Thread> owner = new AtomicReference<>();

    public static void lock(){
        Thread thread = Thread.currentThread();
        if(owner.compareAndSet(null, thread)){
            System.out.println(thread.getName() + " 占用锁成功");
        }else{
            System.out.println(thread.getName() + " 占用锁失败");
        }
    }

//    public static void unlock(){
//        Thread thread = Thread.currentThread();
//        if(owner.compareAndSet(thread, null)){
//            System.out.println(thread.getName() + " 释放锁成功");
//        }else{
//            System.out.println(thread.getName() + " 释放锁失败");
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SpinLock::lock);
        Thread t2 = new Thread(SpinLock::lock);

        t1.start();
        Thread.sleep(2000);
        t2.start();

    }

}
