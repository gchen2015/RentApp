package com.gz.rentapp.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/26.
 */
public class KKZCOrder implements Serializable{
    //添加订单
    private String carId;
    private String address;

    private int insurance;
    private String byCarTime;
    private String backCarTime;
    private String renterIdCard;
    private int rentCarMoney;
    private int rent;
    private String orderNum;
    private String renterPhone;
    private int totalMoney;
    private String orderId;

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

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public String getByCarTime() {
        return byCarTime;
    }

    public void setByCarTime(String byCarTime) {
        this.byCarTime = byCarTime;
    }

    public String getBackCarTime() {
        return backCarTime;
    }

    public void setBackCarTime(String backCarTime) {
        this.backCarTime = backCarTime;
    }

    public String getRenterIdCard() {
        return renterIdCard;
    }

    public void setRenterIdCard(String renterIdCard) {
        this.renterIdCard = renterIdCard;
    }

    public int getRentCarMoney() {
        return rentCarMoney;
    }

    public void setRentCarMoney(int rentCarMoney) {
        this.rentCarMoney = rentCarMoney;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRenterPhone() {
        return renterPhone;
    }

    public void setRenterPhone(String renterPhone) {
        this.renterPhone = renterPhone;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
