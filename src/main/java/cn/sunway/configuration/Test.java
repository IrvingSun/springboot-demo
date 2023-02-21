package cn.sunway.configuration;

import cn.sunway.bean.User;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * 验证 Spring SPI机制
 * 使用SpringFactoriesLoader加载配置的
 * @author sunw
 * @date 2023/2/20
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<String> classNames = SpringFactoriesLoader.loadFactoryNames(MyEnableAutoConfiguration.class,
                MyEnableAutoConfiguration.class.getClassLoader());
        classNames.forEach(System.out::println);
        List<User> objs = SpringFactoriesLoader.loadFactories(User.class, MyEnableAutoConfiguration.class.getClassLoader());
        objs.forEach(System.out::println);
    }
}
