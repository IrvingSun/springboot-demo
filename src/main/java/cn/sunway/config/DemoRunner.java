package cn.sunway.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author sunw
 * @date 2023/2/9
 */
@Component
public class DemoRunner implements ApplicationRunner, CommandLineRunner{
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DemoRunner-ApplicationRunner 被调用");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DemoRunner-CommandLineRunner 被调用");
    }
}
