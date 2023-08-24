package cn.sunway.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * @author sunw
 * @date 2023/5/30
 */
@Component
public class TargetMethod {
    @SentinelResource(value = "findUserName", blockHandler = "blockHandlerForUserName")
    public String findUserName(String id) {
        return "RETURN " + id;
    }

    public String blockHandlerForUserName(String id, BlockException e) {
        // 被限流后的处理方法
        return "";
    }
}
