package cn.sunway.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/3/28
 */
public class InterruptExample {

    public static void main(String[] args) {

        Thread sleepThread = new Thread(() -> {
//            try {
//                while(!Thread.currentThread().isInterrupted()) {
//                    TimeUnit.SECONDS.sleep(500);
//                }
//            } catch (InterruptedException e) {
//                System.out.println("接收到中断异常");
//            }
//            System.out.println("sleepThread - 线程结束了");

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("接收到中断异常");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("sleepThread - 线程结束了");
        }, "sleepThread");

        sleepThread.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("调用中断之前，线程的中断状态：" + sleepThread.isInterrupted());

        sleepThread.interrupt();

        System.out.println("调用中断之后，线程的中断状态：" + sleepThread.isInterrupted());

    }
}

