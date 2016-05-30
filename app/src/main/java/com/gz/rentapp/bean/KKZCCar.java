package com.gz.rentapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26.
 */
public class KKZCCar implements Serializable{
    //车辆详情
    private String carId;
    private String address;
    private String carName;
    private int money;
    private String plateNum;

    private String carConfig;
    private List<String> images;
    private String carYear;
    private String longitude;
    private int carEmissions;
    private String latitude;

    private int transmission;
    private String note;

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

    public String getCarConfig() {
        return carConfig;
    }

    public void setCarConfig(String carConfig) {
        this.carConfig = carConfig;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getCarEmissions() {
        return carEmissions;
    }

    public void setCarEmissions(int carEmissions) {
        this.carEmissions = carEmissions;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getTransmission() {
        return transmission;
    }

    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
