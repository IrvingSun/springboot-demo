package cn.sunway.juc;

import java.util.concurrent.RecursiveTask;

class Fibonacci extends RecursiveTask<Integer> {

    int n;

    public Fibonacci(int n) { 

        this.n = n;

    } 

    @Override

    public Integer compute() { 

        if (n <= 1) { 

            return n;

        } 

    Fibonacci f1 = new Fibonacci(n - 1);

    f1.fork();

    Fibonacci f2 = new Fibonacci(n - 2);

    f2.fork();

    return f1.join() + f2.join();

    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(6);
        System.out.println(fibonacci.compute());
    }
 }
