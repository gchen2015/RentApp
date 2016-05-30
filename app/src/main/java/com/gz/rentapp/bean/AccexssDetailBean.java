package com.gz.rentapp.bean;

/**
 * @Package com.gz.rentapp.bean
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/28
 * @修 改 人:
 * @日 期:
 */
public class AccexssDetailBean {
    private AccessData access_token;
    private String goods_id;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public AccessData getAccess_token() {
        return access_token;
    }

    public void setAccess_token(AccessData access_token) {
        this.access_token = access_token;
    }
}
