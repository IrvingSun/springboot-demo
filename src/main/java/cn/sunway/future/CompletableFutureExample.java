package cn.sunway.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author sunw
 * @date 2023/4/20
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<ExmapleObj>> sourceFuture = CompletableFuture.supplyAsync(() -> {
            List<ExmapleObj> list = new ArrayList<>();
            list.add(new ExmapleObj("A"));
            list.add(new ExmapleObj("B"));
            list.add(new ExmapleObj("C"));
            System.out.println(Thread.currentThread().getName() + " 构造原始数据");
            return list;
        });
        CompletableFuture cf = sourceFuture.thenApplyAsync(objs -> {
            objs.stream().map(obj1 ->
                    CompletableFuture.supplyAsync(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + " 第一次加工数据");
                        obj1.setParamA("ParamA-value");
                        return obj1;
                    }).thenCompose(obj2 -> CompletableFuture.supplyAsync(() ->{
                        System.out.println(Thread.currentThread().getName() + " 第二次加工数据");
                        obj2.setParamB("ParamB-value");
                        return obj2;
                    }
                    ))
            ).toArray(size -> new CompletableFuture[size]);
            return objs;
        });
        System.out.println(cf.handleAsync((objs, th) -> th != null ? "系统繁忙" : objs).get());
    }
}

class ExmapleObj{
    private String name;
    private String paramA;
    private String paramB;

    public ExmapleObj(String name) {
        this.name = name;
    }

    public String getParamA() {
        return paramA;
    }

    public void setParamA(String paramA) {
        this.paramA = paramA;
    }

    public String getParamB() {
        return paramB;
    }

    public void setParamB(String paramB) {
        this.paramB = paramB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExmpleObj{" +
                "name='" + name + '\'' +
                ", paramA='" + paramA + '\'' +
                ", paramB='" + paramB + '\'' +
                '}';
    }
}