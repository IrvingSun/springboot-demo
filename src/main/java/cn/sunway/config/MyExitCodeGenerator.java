package cn.sunway.config;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @author sunw
 * @date 2023/2/20
 */
@Component
public class MyExitCodeGenerator implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        System.out.println("MyExitCodeGenerator return 100");
        return 100;
    }
}
