package com.agr.agrsecurity.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linkq
 * @create 2024/1/10
 */
@Data
public class RestResponse<T> implements Serializable {


    private int code;

    private int cost;

    private String message;

    private T data;



    public static RestResponse<?> failCode(ResponseCode responseCode){
        return new RestResponse(responseCode.getCode(), 0,responseCode.getMessage(), null);

    }

    public static <T> RestResponse success(T o){

        return new RestResponse(ResponseCode.SUCCESS.getCode(), 0,ResponseCode.SUCCESS.getMessage(), o);
    }

    public static <T> RestResponse success(){

        return new RestResponse(ResponseCode.SUCCESS.getCode(), 0,ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> RestResponse successCode(ResponseCode responseCode){
        return new RestResponse(responseCode.getCode(), 0,responseCode.getMessage(), null);
    }

    public static <T> RestResponse build(ResponseCode responseCode){
        return new RestResponse(responseCode.getCode(), 0,responseCode.getMessage(), null);
    }

    public RestResponse(int code, int cost, String message, T data) {
        this.code = code;
        this.cost = cost;
        this.message = message;
        this.data = data;
    }
}
