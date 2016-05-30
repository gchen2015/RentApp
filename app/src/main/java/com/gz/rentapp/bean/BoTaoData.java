package com.gz.rentapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class BoTaoData implements Serializable{
    private List<String> imageId;
    private int pageNo;
    private int pageSize;
    private int pageTotalCount;

    public List<String> getImageId() {
        return imageId;
    }

    public void setImageId(List<String> imageId) {
        this.imageId = imageId;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    @Override
    public String toString() {
        return "BoTaoData{" +
                "imageId='" + imageId + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                '}';
    }
}
