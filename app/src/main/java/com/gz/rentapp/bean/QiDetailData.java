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
public class QiDetailData implements Serializable{
    private String id;
    private String goods_type;
    private String goods_name;
    private String shop_price;
    private String market_price;
    private String last_update;
    private String is_need_hotel;
    private String is_need_flight;
    private String is_need_passport;
    private String goods_brief;
    private String age_attr_id;
    private List<QiSkuBean> goods_sku;
    private List<QIPicBean> pictures;
    private List<QiProBean> properties;
    private List<QiSpecBean> specification;
    private List<QiBriefBean> brief;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getIs_need_hotel() {
        return is_need_hotel;
    }

    public void setIs_need_hotel(String is_need_hotel) {
        this.is_need_hotel = is_need_hotel;
    }

    public String getIs_need_flight() {
        return is_need_flight;
    }

    public void setIs_need_flight(String is_need_flight) {
        this.is_need_flight = is_need_flight;
    }

    public String getIs_need_passport() {
        return is_need_passport;
    }

    public void setIs_need_passport(String is_need_passport) {
        this.is_need_passport = is_need_passport;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getAge_attr_id() {
        return age_attr_id;
    }

    public void setAge_attr_id(String age_attr_id) {
        this.age_attr_id = age_attr_id;
    }

    public List<QiSkuBean> getGoods_sku() {
        return goods_sku;
    }

    public void setGoods_sku(List<QiSkuBean> goods_sku) {
        this.goods_sku = goods_sku;
    }

    public List<QIPicBean> getPictures() {
        return pictures;
    }

    public void setPictures(List<QIPicBean> pictures) {
        this.pictures = pictures;
    }

    public List<QiProBean> getProperties() {
        return properties;
    }

    public void setProperties(List<QiProBean> properties) {
        this.properties = properties;
    }

    public List<QiSpecBean> getSpecification() {
        return specification;
    }

    public void setSpecification(List<QiSpecBean> specification) {
        this.specification = specification;
    }

    public List<QiBriefBean> getBrief() {
        return brief;
    }

    public void setBrief(List<QiBriefBean> brief) {
        this.brief = brief;
    }

    @Override
    public String toString() {
        return "QiDetailData{" +
                "id='" + id + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", market_price='" + market_price + '\'' +
                ", last_update='" + last_update + '\'' +
                ", is_need_hotel='" + is_need_hotel + '\'' +
                ", is_need_flight='" + is_need_flight + '\'' +
                ", is_need_passport='" + is_need_passport + '\'' +
                ", goods_brief='" + goods_brief + '\'' +
                ", age_attr_id='" + age_attr_id + '\'' +
                ", goods_sku=" + goods_sku +
                ", pictures=" + pictures +
                ", properties=" + properties +
                ", specification=" + specification +
                ", brif=" + brief +
                '}';
    }
}
