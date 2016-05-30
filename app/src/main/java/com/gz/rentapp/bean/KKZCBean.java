package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26.
 */
public class KKZCBean implements Serializable{
    private String code;
    private boolean success;
    private String msg;
    private String obj;
    private String attributes;
    private KKZCData data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public KKZCData getData() {
        return data;
    }

    public void setData(KKZCData data) {
        this.data = data;
    }
}
