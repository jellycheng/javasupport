package com.jellycheng.javasupport.utils;

import java.io.Serializable;

public class ApiResponseV1<T> implements Serializable {
    private int code; // 自定义状态码，默认0,如果是Integer类型则默认为null
    private String msg; // 错误消息,默认null
    private T data;   // 返回的数据

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // 成功时的静态工厂方法
    public static <T> ApiResponseV1<T> success(T data) {
        ApiResponseV1<T> response = new ApiResponseV1<>();
        response.setCode(0);     // 自定义成功码
        response.setData(data); // data 值
        response.setMsg("success");
        return response;
    }

    // 失败时的静态工厂方法： ApiResponse.error("错误信息内容", 200);
    public static <T> ApiResponseV1<T> error(String message, int errorCode) {
        ApiResponseV1<T> response = new ApiResponseV1<>();
        response.setCode(errorCode); // 自定义错误码
        response.setMsg(message);
        return response;
    }

}