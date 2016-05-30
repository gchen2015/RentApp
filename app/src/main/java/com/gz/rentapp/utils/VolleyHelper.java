package com.gz.rentapp.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.gz.rentapp.app.BaseApp;

/**
 * Created by Administrator on 2016/3/11.
 */
public class VolleyHelper {
    private static VolleyHelper volleyHelper;
    private RequestQueue queue;
    private ImageLoader imageLoader;
    private VolleyHelper(){
        getQueue();
    }
    public static VolleyHelper getInstance(){
        if (volleyHelper==null){
            volleyHelper=new VolleyHelper();
        }
        return volleyHelper;
    }
    /**
     *获取请求队列
     */
    public  RequestQueue getQueue(){
        if (queue==null){
            queue= Volley.newRequestQueue(BaseApp.getInstance());
        }
        return queue;
    }
    /**
     *获取imageloader
     */
    public ImageLoader getImageLoader(){
        if (imageLoader==null){
            imageLoader=new ImageLoader(queue,AppImageCache.getImageCache());
        }
        return imageLoader;
    }
    /**
     * 获取请求到消息队列的方法
     */
    public <T>void addRequest(Request<T> request){
        getQueue().add(request);
    }
    /**
     * 取消所有请求的方法
     */
    public void cancelAll(Object tag){
        getQueue().cancelAll(tag);
    }
}
