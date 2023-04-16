package cn.sunway.juc;

/**
 * @author sunw
 * @date 2023/4/13
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("t1-value");
                System.out.println(threadLocal.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("t1-value");
                System.out.println(threadLocal.get());
            }
        });

        System.out.println(threadLocal.get());

        t1.start();
        t2.start();

    }
}
