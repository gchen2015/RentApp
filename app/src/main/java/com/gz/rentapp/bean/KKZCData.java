package com.gz.rentapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class KKZCData implements Serializable{
      private KKZCOrder order;
      private KKZCCar car;
      private List<KKZCList> listcar;

    public KKZCOrder getOrder() {
        return order;
    }

    public void setOrder(KKZCOrder order) {
        this.order = order;
    }

    public KKZCCar getCar() {
        return car;
    }

    public void setCar(KKZCCar car) {
        this.car = car;
    }

    public List<KKZCList> getListcar() {
        return listcar;
    }

    public void setListcar(List<KKZCList> listcar) {
        this.listcar = listcar;
    }
}
