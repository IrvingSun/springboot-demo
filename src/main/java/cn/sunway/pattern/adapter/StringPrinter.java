package cn.sunway.pattern.adapter;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class StringPrinter implements Printer{
    @Override
    public void print(String s) {
        System.out.println("I got a string, value is = " + s);
    }
}
