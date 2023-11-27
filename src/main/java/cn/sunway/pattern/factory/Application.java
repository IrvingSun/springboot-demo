package cn.sunway.pattern.factory;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class Application {
    private static GUIFactory guiFactory;

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        if (osName.equals("WIN")) {
            guiFactory = new WinFactory();
        } else if (osName.equals("Mac OS X")) {
            guiFactory = new MacFactory();
        } else {
            return;
        }
        Button button = guiFactory.createButton();
        System.out.println(button.getClass());
    }
}
