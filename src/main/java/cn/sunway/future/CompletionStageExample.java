package cn.sunway.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author sunw
 * @date 2023/4/20
 */
public class CompletionStageExample {

    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "remote result");
        cf.thenAcceptAsync(result -> System.out.println("cf 结果 ： " + result));
    }

}
