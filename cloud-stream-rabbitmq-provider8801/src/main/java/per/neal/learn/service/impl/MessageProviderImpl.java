package per.neal.learn.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import per.neal.learn.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class) //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送通道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 消息的发送
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("=============serial:{}", serial);
        return null;
    }
}
