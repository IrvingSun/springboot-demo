package cn.sunway.pattern.factory;

/**
 * @author sunw
 * @date 2023/11/22
 */
public class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
