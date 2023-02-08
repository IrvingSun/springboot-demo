package cn.sunway.config;

/**
 * @author sunw
 * @date 2023/2/7
 */
public class DemoObject {
    private String tip;
    private InnerDemoObject innerDemoObject;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public InnerDemoObject getInnerDemoObject() {
        return innerDemoObject;
    }

    public void setInnerDemoObject(InnerDemoObject innerDemoObject) {
        this.innerDemoObject = innerDemoObject;
    }
}
