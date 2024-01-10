package com.agr.agrsecurity.entry;

public enum ResponseCode {

    SUCCESS(0,"success"),
    USER_NEED_LOGIN(1001,"用户需要登入"),
    USER_LOGIN_TIMEOUT(1002,"用户登入超时"),
    USER_MAX_LOGIN(1003,"用户重复登入"),
    NO_AUTHENTICATION(2001,"没有权限"),
    ;

    private int code;

    private String message;


    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
