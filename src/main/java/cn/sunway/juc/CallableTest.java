package cn.sunway.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author sunw
 * @date 2023/3/28
 */
public class CallableTest implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }


    public static void main(String[] args)throws Exception {
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> futureTask = new FutureTask(callableTest);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("GET NEW INTEGER, VALUE = " + futureTask.get());
    }
}
