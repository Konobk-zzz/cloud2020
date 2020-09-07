package com.zja.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zja.springcloud.entity.CommonResult;

/**
 * @Author zhujiaao
 * @Date 2020/9/6 15:09
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return CommonResult.errorMsg("全局Sentinel处理器！");
    }

    public static CommonResult handlerException2(BlockException exception){
        return CommonResult.errorMsg("全局Sentinel处理器！ 2号机");
    }
}
