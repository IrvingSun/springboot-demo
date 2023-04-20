package cn.sunway.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author sunw
 * @date 2023/4/20
 */
public class AllOfExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture c1 = CompletableFuture.supplyAsync(() -> "c1 result");
        CompletableFuture c2 = CompletableFuture.supplyAsync(() -> "c2 result");

        CompletableFuture.anyOf(c1, c2).thenAccept(System.out::println).join();
    }
}
