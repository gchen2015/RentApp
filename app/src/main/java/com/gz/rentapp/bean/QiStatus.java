package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * @Package com.gz.rentapp.bean
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/27
 * @修 改 人:
 * @日 期:
 */
public class QiStatus implements Serializable{
    private int succeed;

    public int getSucceed() {
        return succeed;
    }

    public void setSucceed(int succeed) {
        this.succeed = succeed;
    }

    @Override
    public String toString() {
        return "QiStatus{" +
                "succeed=" + succeed +
                '}';
    }
}
