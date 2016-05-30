package com.gz.rentapp.bean;

/**
 * Created by Administrator on 2016/5/29 0029.
 */
public class Msg {
    private int id;

    public Msg() {

    }

    public Msg(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "id=" + id +
                '}';
    }
}
