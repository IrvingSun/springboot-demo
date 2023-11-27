package cn.sunway.pattern.adapter;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class PringDemo {

    public static void main(String[] args) {
        PrinterIntegerAdapter printer = new PrinterIntegerAdapter();
        printer.printInteger(10002);
    }
}
