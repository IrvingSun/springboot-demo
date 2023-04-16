package cn.sunway.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunw
 * @date 2023/4/12
 */
public class ConditionMain {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ConditionExampleWait conditionExampleWait = new ConditionExampleWait(lock, condition);
        ConditionExampleSignal conditionExampleSignal = new ConditionExampleSignal(lock, condition);
        new Thread(conditionExampleWait).start();
        Thread.sleep(1000);
        new Thread(conditionExampleSignal).start();
    }
}
