package com.gz.rentapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.gz.rentapp.bean
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/28
 * @修 改 人:
 * @日 期:
 */
public class QiSkuBean implements Serializable{
    private String sku_id;
    private String price;
    private List<QiArrBean> sku_arrt;

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<QiArrBean> getSku_arrt() {
        return sku_arrt;
    }

    public void setSku_arrt(List<QiArrBean> sku_arrt) {
        this.sku_arrt = sku_arrt;
    }

    @Override
    public String toString() {
        return "QiSkuBean{" +
                "sku_id='" + sku_id + '\'' +
                ", price='" + price + '\'' +
                ", sku_arrt=" + sku_arrt +
                '}';
    }
}
