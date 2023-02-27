package cn.sunway.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author sunw
 * @date 2023/2/24
 */
public class Test {
    public static void main(String[] args) {
        //实例化实现类，调用方法
        IMath math = new BasicMath();
        System.out.println(math.add(1, 2));

        System.out.println("---------------------------------");

        //提供函数式实现
        IMath functionalMath = (a, b) -> a + b + 100;
        functionalMath.desc();
        IMath.version();
        System.out.println(functionalMath.add(1, 2));

        System.out.println("---------------------------------");

        //接口作为参数(函数式接口)
        testMath(functionalMath, 4, 5);

        //Java8内置函数式接口 - Predicate
        Predicate<String> isEmpty = (s) -> s == null || s.length() == 0;
        System.out.println(isEmpty.test(""));

        //Java8内置函数式接口 - Consumer
        Consumer<Collection> print = (collection) -> collection.forEach(System.out::println);
        List list = new ArrayList();
        list.add("周瑜");
        list.add("诸葛亮");
        list.add("司马懿");
        print.accept(list);

        //Java8内置函数式接口 - Function
        Function<String, String> function = (pwd) -> Base64.getEncoder().encodeToString(pwd.getBytes());
        System.out.println(function.apply("123"));

        //Java8内置函数式接口 - Supplier
        Supplier<Integer> integerSupplier = () -> new Random(3).nextInt();
        System.out.println(integerSupplier.get().intValue());

        System.out.println("---------------------------------");

       //

    }

    static void testMath(IMath iMath, int a, int b){
        iMath.desc();
        IMath.version();
        System.out.println(iMath.add(a,b));
    }
}
