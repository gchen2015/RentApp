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
public class QIzhouBean implements Serializable{
    private QiStatus status;
    private QiPaginated paginated;
    private List<QiData> data;

    public QiStatus getStatus() {
        return status;
    }

    public void setStatus(QiStatus status) {
        this.status = status;
    }

    public QiPaginated getPaginated() {
        return paginated;
    }

    public void setPaginated(QiPaginated paginated) {
        this.paginated = paginated;
    }

    public List<QiData> getData() {
        return data;
    }

    public void setData(List<QiData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QIzhouBean{" +
                "status=" + status +
                ", paginated=" + paginated +
                ", data=" + data +
                '}';
    }
}
