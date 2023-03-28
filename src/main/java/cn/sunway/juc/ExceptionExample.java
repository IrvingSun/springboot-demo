package cn.sunway.juc;

/**
 * @author sunw
 * @date 2023/3/29
 */
public class ExceptionExample {

    public static void main(String[] args) {
        try {
            while (Thread.currentThread().isInterrupted()) {
                int i = 1 / 0;
            }
        }catch (Exception e){
            e.printStackTrace();
//            Thread.interrupted();
        }
    }
}
