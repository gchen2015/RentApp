package com.gz.rentapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.gz.rentapp.bean
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/27
 * @修 改 人:
 * @日 期:
 */
public class QiData implements Serializable{
    private String goods_id;
    private String name;

    @Override
    public String toString() {
        return "QiData{" +
                "goods_id='" + goods_id + '\'' +
                ", name='" + name + '\'' +
                ", market_price='" + market_price + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", promote_price='" + promote_price + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", dest_id='" + dest_id + '\'' +
                ", last_update='" + last_update + '\'' +
                ", goods_brief='" + goods_brief + '\'' +
                ", img=" + img +
                '}';
    }

    private String market_price;
    private String shop_price;
    private String promote_price;
    private String goods_type;
    private String dest_id;
    private String last_update;
    private String goods_brief;
    private QiImg img;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(String promote_price) {
        this.promote_price = promote_price;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getDest_id() {
        return dest_id;
    }

    public void setDest_id(String dest_id) {
        this.dest_id = dest_id;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public QiImg getImg() {
        return img;
    }

    public void setImg(QiImg img) {
        this.img = img;
    }
}
