package cn.sunway.config;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

/**
 * @author sunw
 * @date 2023/2/10
 */
public class DemoFailureAnalyzer extends AbstractFailureAnalyzer<PortInUseException>{

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, PortInUseException cause) {
        return new FailureAnalysis("Yeah, 自定义失败分析器出现了...!",
                "Ummm... 啥都不做，删库跑路",
                cause);
    }
}
