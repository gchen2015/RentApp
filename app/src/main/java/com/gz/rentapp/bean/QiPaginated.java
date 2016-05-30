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
public class QiPaginated implements Serializable{
    private int total;
    private int count;
    private int more;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    @Override
    public String toString() {
        return "QiPaginated{" +
                "total=" + total +
                ", count=" + count +
                ", more=" + more +
                '}';
    }
}
