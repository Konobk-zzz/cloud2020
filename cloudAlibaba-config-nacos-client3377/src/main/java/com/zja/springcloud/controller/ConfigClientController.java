package com.zja.springcloud.controller;

import com.zja.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhujiaao
 * @Date 2020/9/5 11:01
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public CommonResult getConfigInfo(){
        return CommonResult.successData(configInfo);
    }
}
