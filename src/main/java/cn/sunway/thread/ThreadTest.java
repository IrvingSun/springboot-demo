package cn.sunway.thread;

/**
 * @author sunw
 * @date 2023/3/21
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> System.out.println("Thread run..."+ Thread.currentThread().getName()));
////        thread.start();
//
//
//        System.out.println(Thread.currentThread().getName());
//        Thread thread2 = new Thread(() ->
//            System.out.println("Thread2 run..." + Thread.currentThread().getName())
//        );
//
//        thread2.start();
////        thread2.join();
//        thread.start();
////        thread.join();
//        System.out.println("线程组： " + Thread.currentThread().getThreadGroup().getName() + ",线程数量：" + Thread.currentThread().getThreadGroup().activeCount());


        Thread thread3 = new Thread();
        thread3.start();

        System.out.println(Thread.currentThread().getName());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("only runnable");
                System.out.println(Thread.currentThread().getName());
            }
        };

        runnable.run();


        Thread stopThread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("可退出的任务正在执行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    System.out.println("可退出的任务当前状态1 = " + Thread.currentThread().getState());
                }
            }
            System.out.println("可退出的任务正在结束");
        });

        stopThread.start();

        Thread.sleep(3000);
        System.out.println("可退出的任务当前状态2 = " + stopThread.getState());

        System.out.println("主线程准备发出「可退出的任务」中断信号");
        stopThread.interrupt();
        System.out.println("可退出的任务当前状态3 = " + stopThread.getState());
        Thread.sleep(1000);
        System.out.println("可退出的任务当前状态4 = " + stopThread.getState());
    }
}
