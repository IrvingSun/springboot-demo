package cn.sunway.pattern.adapter;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class PrinterIntegerAdapter extends IntegerPrinter implements Printer {
    StringPrinter stringPrinter = new StringPrinter();

    @Override
    public void print(String s) {
        stringPrinter.print(s);
    }

    @Override
    void printInteger(Integer s) {
        print(Integer.toString(s) + "----");
    }
}
