//package cn.sunway.controller;
//
//import cn.sunway.config.DemoObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Objects;
//
///**
// * @author sunw
// * @date 2023/2/1
// */
//@RestController
//public class DemoController {
//
//    @Autowired(required = false)
//    private DemoObject demoObject;
//
//    @RequestMapping("/demo")
//    String home() {
//        return "Hello! Home page \n" + (Objects.isNull(demoObject) ? "未加载字符串" : demoObject.getTip() + "Object地址：" + demoObject);
//    }
//
//}
