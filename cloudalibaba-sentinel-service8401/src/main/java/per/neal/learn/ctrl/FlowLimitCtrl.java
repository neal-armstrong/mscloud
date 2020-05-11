package per.neal.learn.ctrl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitCtrl {
    @GetMapping(value = "/testA")
    public String testA() {
        return "===============Test A";
    }

    @GetMapping(value = "/testB")
    public String testB() {
        return "================Test B";
    }

    @GetMapping(value = "/testD")
    public String testD() {
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("testD 测试 RT");
        int age = 10 / 0;
        return "================Test D";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "=======testHotKey=========";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "======deal_testHotKey======";

    }
}
