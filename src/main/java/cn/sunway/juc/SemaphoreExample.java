package cn.sunway.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/4/13
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i= 0; i <100; i++){
            service.execute(new SomeTask(semaphore));
        }
        service.shutdown();
    }

    static class SomeTask implements Runnable{
        private Semaphore semaphore;

        public SomeTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "获得一个令牌");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "释放一个令牌");
                semaphore.release();
            }
        }
    }

}
