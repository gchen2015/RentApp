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
public class QiBriefBean implements Serializable{
     private String ti_id;
    private String ti_label;
    private String ti_title;
    private String value;

    public String getTi_id() {
        return ti_id;
    }

    public void setTi_id(String ti_id) {
        this.ti_id = ti_id;
    }

    public String getTi_label() {
        return ti_label;
    }

    public void setTi_label(String ti_label) {
        this.ti_label = ti_label;
    }

    public String getTi_title() {
        return ti_title;
    }

    public void setTi_title(String ti_title) {
        this.ti_title = ti_title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "QiBriefBean{" +
                "ti_id='" + ti_id + '\'' +
                ", ti_label='" + ti_label + '\'' +
                ", ti_title='" + ti_title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
