package com.gz.rentapp.db;

/**
 * @Package com.gz.rentapp.db
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/27
 * @修 改 人:
 * @日 期:
 */
public class QiZhouDb {
    public static  String PARTNERID="2351";
    public static  String ACCESSKEY="C6255D70A3";
    public static  String ACCESSSREC="BE18CD3D868CD42988198A62DE7F8ACD";
    public static  String BASE_URL="http://42.121.12.194:8080/";
    //4.服务列表接口
    public static String getLook(){
        return BASE_URL+"search";
    }
    //指定详情
    public static String getService(){
        return BASE_URL+"goods/service_introduce";
    }
}
