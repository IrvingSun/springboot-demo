package cn.sunway.pattern.factory;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class WinFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
