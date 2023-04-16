package cn.sunway.juc;

import sun.misc.Contended;

/**
 * 高速缓存行
 * 缓存行，如果数据不合理，将带来效率下降问题
 * 缓存行，大小64字节，即每个字节8位
 * CPU加载内存数据到缓存时，会将临近的64位 数据同时加载进去
 * 一个long 8 字节，所以一次会加载8个long数据
 *
 * @author sunw
 * @date 2023/3/30
 */
public class FakeLineShareExample implements Runnable{
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private int arrayIndex = 0 ;
    private static ValueNoPadding longs[];

    public FakeLineShareExample(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i < 10; i++){
            System.gc();
            final long start = System.currentTimeMillis();
            runTest(i);
            System.out.println(i + " Threads, duration = " + (System.currentTimeMillis() - start));
        }
    }

    private static void  runTest(int NUM_THREADS)throws InterruptedException{
       Thread[] threads = new Thread[NUM_THREADS];
       longs = new ValueNoPadding[NUM_THREADS];
       for(int i = 0; i<longs.length; i++){
           longs[i] = new ValueNoPadding();
       }
       for(int i = 0; i < threads.length; i++){
           threads[i] = new Thread(new FakeLineShareExample(i));
       }
       for(Thread t : threads){
           t.start();
       }
        for(Thread t : threads){
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while(0 != --i){
            longs[arrayIndex].value = 0L;
        }
    }

    public final static class ValuePadding{
        protected  long p1,p2,p3,p4,p5, p6, p7;
        protected  long value = 0;
        protected  long p9, p10, p11, p12, p13, p14, p15;
    }

    @Contended
    public final static class ValueNoPadding{
        protected  long value = 0;
    }
}
