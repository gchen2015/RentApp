package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26.
 */
public class KKZCList implements Serializable{
    //车辆列表
    private String carId;
    private String address;
    private String imagePic;
    private String distanceNum;
    private String carName;
    private int money;
    private String plateNum;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePic() {
        return imagePic;
    }

    public void setImagePic(String imagePic) {
        this.imagePic = imagePic;
    }

    public String getDistanceNum() {
        return distanceNum;
    }

    public void setDistanceNum(String distanceNum) {
        this.distanceNum = distanceNum;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }
}
