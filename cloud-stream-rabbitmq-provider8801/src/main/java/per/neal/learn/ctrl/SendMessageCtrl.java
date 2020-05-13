package per.neal.learn.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import per.neal.learn.service.IMessageProvider;

import javax.annotation.Resource;

@RestController
public class SendMessageCtrl {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
