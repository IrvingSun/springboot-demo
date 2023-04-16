package cn.sunway.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author sunw
 * @date 2023/4/12
 */
public class ConditionExampleWait implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionExampleWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin - conditionExampleWait");
        try{
            lock.lock();
            condition.await();
            System.out.println("end - conditionExampleWait");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
