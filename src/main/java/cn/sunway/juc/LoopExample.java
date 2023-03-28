package cn.sunway.juc;

/**
 * @author sunw
 * @date 2023/3/29
 */
public class LoopExample {

    public static void main(String[] args) {
        Thread thead = new Thread(() ->{
            int i = 1;
            while(true){
                i = i/2;
            }
        });
        thead.start();
    }
}
