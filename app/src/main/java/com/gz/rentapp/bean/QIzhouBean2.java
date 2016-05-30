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
public class QIzhouBean2 implements Serializable{
    private QiStatus status;
    private QiDetailData data;

    public QiStatus getStatus() {
        return status;
    }

    public void setStatus(QiStatus status) {
        this.status = status;
    }


    public QiDetailData getData() {
        return data;
    }

    public void setData(QiDetailData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QIzhouBean2{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
