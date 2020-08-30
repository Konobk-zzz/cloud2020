package com.zja.springcloud.service.impl;

import com.zja.springcloud.service.IMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author zhujiaao
 * @Date 2020/8/29 22:04
 * @Version 1.0
 */
@EnableBinding(Source.class)
@Slf4j
public class IMessageImpl implements IMessage {
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("****serial:"+serial);
        return null;
    }
}
