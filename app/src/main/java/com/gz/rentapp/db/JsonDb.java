package com.gz.rentapp.db;

/**
 * Created by Administrator on 2016/5/26.
 */
public class JsonDb {
    /**
     * 铂涛
     * APPID 和 HEADER 是成对出现的
     */
    public static  String appId = "1001";
    public static  String token = "8BBF9133E791B2EEB609B5D631E7E45D";
    public static final String USER_REGISTER_URL = "http://120.25.228.148/geek2016/8081/rest/member/%s";

    //按标签获取图片
    public static String getImagePage(){
        return "http://120.25.228.148/geek2016/8082/label"+"/getImagePage/%s/%s/%s";
    }
    //按标签获取图片
    public static String getResign(){
        return "http://120.25.228.148/geek2016/8081/rest/member";
    }
    //快快租车api头连接
    public static String BASE_URL="http://m.kuaikuaizuche.com/Kkzc/kkzcapi/";
    //快快租车添加订单接口
    public static String getTaxtList(){
        return BASE_URL+"carList.do";
    }
    //快快租车车辆详情
    public static String getTaxtDetail(String carId){
        return BASE_URL+"carDetail.do?carId="+carId;
    }
    //快快租车车辆列表
    public static String getCartOrder(String carId,String phone,String IdCard){
        return BASE_URL+"addOrder.do?carId="+carId+"&phone="+phone+"&IdCard="+IdCard;
    }
    public static String GETIMAGE="http://m.kuaikuaizuche.com/";

}
