package cn.sunway.future;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author sunw
 * @date 2023/4/19
 */
public class FutureCallbackExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 1, y = 1;
        Callable callable = () -> {
            System.out.println("begin call: " + new Date());
            TimeUnit.SECONDS.sleep(2);
            return x + y;
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        System.out.println("begin task: " + new Date());
        Thread thread = new Thread(() ->{
            try {
                System.out.println("新建的thread也在等待结果中..");
                System.out.println("新建的thread获得结果：" + futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Integer result = futureTask.get();
        System.out.println("result = " + result);
        System.out.println("get2 = " + futureTask.get());
    }
}
