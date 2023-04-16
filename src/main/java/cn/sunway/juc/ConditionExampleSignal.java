package cn.sunway.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author sunw
 * @date 2023/4/12
 */
public class ConditionExampleSignal implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionExampleSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("ConditionExampleSignal begin");
        try{
            lock.lock();
            condition.signal();
            System.out.println("ConditionExampleSignal end");
        }finally {
            lock.unlock();
        }
    }
}
