package cn.sunway.bean;

import cn.sunway.annotation.DemoAnnotation;

/**
 * @author sunw
 * @date 2023/2/21
 */
@DemoAnnotation
public class AnnotationUser {
    private String name = "AnnotationUser-name";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:"+name;
    }
}
