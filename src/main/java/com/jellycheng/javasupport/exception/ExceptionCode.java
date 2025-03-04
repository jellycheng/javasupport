package com.jellycheng.javasupport.exception;

public enum ExceptionCode implements IExceptionCode{
    SUCCESS(0, "成功"),
    NOT_LOGIN(100, "未登录"),
    DEFINE_ERROR(999, "%s"),
    ;
    private final int code;
    private String msg;

    ExceptionCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public ExceptionCode editMsg(String msg, Object... param) {
        this.msg = String.format(msg, param);
        return this;
    }

    public ExceptionCode formatMsg(Object... param) {
        msg = String.format(msg, param);
        return this;
    }
}
