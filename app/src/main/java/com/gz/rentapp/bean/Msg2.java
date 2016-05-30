package com.gz.rentapp.bean;

/**
 * Created by Administrator on 2016/5/29 0029.
 */
public class Msg2 {
    private int title;

    public Msg2() {
    }

    public Msg2(int title) {
        this.title = title;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Msg2{" +
                "title=" + title +
                '}';
    }
}
