package cn.sunway.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author sunw
 * @date 2023/4/17
 */
public class ForkJoinExample {
    private static final Integer MAX = 40;

    static class CalculationTask extends RecursiveTask<Integer> {
        private Integer startValue;
        private Integer endValue;

        public CalculationTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            if (endValue - startValue < MAX) {
                System.out.println("开始计算的部分：startValue = " + startValue + "; endValue = " + endValue);
                Integer totalValue = 0;
                for(int index = startValue; index <= this.endValue; index++){
                    totalValue+=index;
                }
                return totalValue;
            }
                return createSubTask();
        }

        private Integer createSubTask(){
            CalculationTask task1 = new CalculationTask(startValue, (startValue + endValue ) /2);
            CalculationTask task2 = new CalculationTask( (startValue + endValue ) /2 + 1 , endValue);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }

        public static void main(String[] args) {
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask<Integer> task = pool.submit(new CalculationTask(1,2002));
            try {
                Integer result = task.get();
                System.out.println("result = " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
