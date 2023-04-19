package cn.sunway.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunw
 * @date 2023/4/18
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Runnable runnable = () ->{
            System.out.println(Thread.currentThread().getName() + " - 开始执行任务");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " - 执行任务完成");
        };

        for(int i = 0; i < 10; i++){
            executorService.execute(runnable);
        }
    }

}
