package com.zja.springcloud.entity;

import lombok.Data;

@Data
public class CommonResult {
    private Integer code;
    private String msg;
    private Object data;

    private final static Integer SUCCESS_CODE=200;
    private final static Integer ERROR_CODE=400;
    private final static String SUCCESS_MSG="操作成功";
    private final static String ERROR_MSG="操作失败";

    public static CommonResult successMsgData(String Msg,Object Data){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setMsg(Msg);
        commonResult.setData(Data);
        return commonResult;
    }

    public static CommonResult successData(Object Data){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setMsg(SUCCESS_MSG);
        commonResult.setData(Data);
        return commonResult;
    }

    public static CommonResult successMsg(String Msg){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setMsg(Msg);
        return commonResult;
    }

    public static CommonResult success(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(SUCCESS_CODE);
        commonResult.setMsg(SUCCESS_MSG);
        return commonResult;
    }

    public static CommonResult errorMsg(String Msg){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ERROR_CODE);
        commonResult.setMsg(Msg);
        return commonResult;
    }

    public static CommonResult error(){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(ERROR_CODE);
        commonResult.setMsg(ERROR_MSG);
        return commonResult;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
