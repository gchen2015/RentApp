package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26.
 */
public class BoTaoBean implements Serializable{
    private int code;
    private String message;
    private BoTaoData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BoTaoData getData() {
        return data;
    }

    public void setData(BoTaoData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BoTaoBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
