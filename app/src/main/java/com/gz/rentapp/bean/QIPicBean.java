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
public class QIPicBean implements Serializable{
    private String small;
    private String thumb;
    private String url;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "QIPicBean{" +
                "small='" + small + '\'' +
                ", thumb='" + thumb + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
