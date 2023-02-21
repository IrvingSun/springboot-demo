//package cn.sunway.postProcessor;
//
//import cn.sunway.annotation.DemoAnnotation;
//import com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.InjectionMetadata;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.core.annotation.AnnotationAttributes;
//
//import java.lang.annotation.Annotation;
//
///**
// * @author sunw
// * @date 2023/2/21
// */
//public class DemoAnnotationBeanProcessor extends AbstractAnnotationBeanPostProcessor implements ApplicationContextAware{
//
//    private ApplicationContext applicationContext;
//
//    public DemoAnnotationBeanProcessor() {
//        super(DemoAnnotation.class);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//            this.applicationContext = applicationContext;
//    }
//
//    @Override
//    protected Object doGetInjectedBean(AnnotationAttributes annotationAttributes, Object o, String s, Class<?> aClass, InjectionMetadata.InjectedElement injectedElement) throws Exception {
//        return o;
//    }
//
//    @Override
//    protected String buildInjectedObjectCacheKey(AnnotationAttributes annotationAttributes, Object o, String s, Class<?> aClass, InjectionMetadata.InjectedElement injectedElement) {
//        return null;
//    }
//}
