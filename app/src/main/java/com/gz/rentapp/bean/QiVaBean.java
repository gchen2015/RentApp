package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * @Package com.gz.rentapp.bean
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/28
 * @修 改 人:
 * @日 期:
 */
public class QiVaBean implements Serializable{
    private String label;
    private String price;
    private String format_price;
    private String id;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFormat_price() {
        return format_price;
    }

    public void setFormat_price(String format_price) {
        this.format_price = format_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
