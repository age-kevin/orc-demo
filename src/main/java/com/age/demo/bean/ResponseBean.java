package com.age.demo.bean;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBean {
    private int rcCode;
    private String message;
    private Object data;
    private boolean success;

    public ResponseBean(int rcCode, String message, Object data, boolean success){
        this.rcCode = rcCode;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public static ResponseBean actionSuccess(Object data, String message){
        ResponseBean bean = new ResponseBean(HttpStatus.OK.value(), message, data, true);
        return bean;
    }

    public static ResponseBean actionFail(String message){
        ResponseBean bean = new ResponseBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, null, false);
        return bean;
    }

}
