package per.neal.learn.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 实现刷新,# curl -X POST "http://localhost:3355/actuator/refresh"进行更新
@RefreshScope
public class ConfigClientCtrl {
    @Value("${config.info}")
    private String configInfo;

    @Value(("${server.port}"))
    private String serverPort;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {
        return configInfo + "\t\n" + serverPort;
    }
}
