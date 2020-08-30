package com.zja.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhujiaao
 * @Date 2020/8/29 16:27
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @Value("${server.port}")
    private String port;

    @GetMapping("/getInfo")
    public String printInfo(){
        return "serverPort:"+port+'\t'+info;
    }
}
