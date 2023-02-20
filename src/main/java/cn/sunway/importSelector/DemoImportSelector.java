package cn.sunway.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过实现 ImportSelector来注入bean
 * @author sunw
 * @date 2023/2/20
 */
public class DemoImportSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("====>调用ImportSelector获取一批类名称");
        return new String[]{"cn.sunway.bean.User"};
    }
}
