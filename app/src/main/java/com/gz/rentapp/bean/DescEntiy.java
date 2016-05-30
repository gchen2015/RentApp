package com.gz.rentapp.bean;

/**
 * Created by Administrator on 2016/5/28.
 */
public class DescEntiy  {
       private String id;
       private String name_zh_cn;
       private String name_en;
       private String poi_count;
       private String lat;
       private String lng;
       private String image_url;
       private String updated_at;

    public DescEntiy(String id, String name_zh_cn, String name_en, String poi_count, String lat, String lng, String image_url, String updated_at) {
        this.id = id;
        this.name_zh_cn = name_zh_cn;
        this.name_en = name_en;
        this.poi_count = poi_count;
        this.lat = lat;
        this.lng = lng;
        this.image_url = image_url;
        this.updated_at = updated_at;
    }

    public DescEntiy() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_zh_cn() {
        return name_zh_cn;
    }

    public void setName_zh_cn(String name_zh_cn) {
        this.name_zh_cn = name_zh_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getPoi_count() {
        return poi_count;
    }

    public void setPoi_count(String poi_count) {
        this.poi_count = poi_count;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
