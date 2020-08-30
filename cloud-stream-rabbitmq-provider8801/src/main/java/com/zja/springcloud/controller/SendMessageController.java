package com.zja.springcloud.controller;

import com.zja.springcloud.service.IMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zhujiaao
 * @Date 2020/8/29 22:12
 * @Version 1.0
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessage message;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return message.send();
    }
}
