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
public class QiSpecBean implements Serializable{
    private String attr_type;
    private String name;
    private String id;
    private List<QiVaBean> value;

    public String getAttr_type() {
        return attr_type;
    }

    public void setAttr_type(String attr_type) {
        this.attr_type = attr_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<QiVaBean> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QiSpecBean{" +
                "attr_type='" + attr_type + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", value=" + value +
                '}';
    }

    public void setValue(List<QiVaBean> value) {
        this.value = value;
    }
}
