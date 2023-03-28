package cn.sunway.juc;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 实现生产消费者模型
 *
 * @author sunw
 * @date 2023/3/27
 */
public class ProducerCustomerTest {

    public static void main(String[] args) {
        queue();
    }

    /**
     * 通过使用ArrayBlockingQueue实现
     */
    private static void queue() {
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    queue.put(new Object());
                    System.out.println("producer -> 添加object，当前size = " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    queue.take();
                    System.out.println("consumer -> 删除object，当前size = " + queue.size());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
