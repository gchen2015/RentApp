package com.gz.rentapp.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/3/11.
 */
public class AppImageCache implements ImageLoader.ImageCache{
    private static AppImageCache cache;
    private LruCache<String,Bitmap> lruCache;
    private AppImageCache(){
        getLruCache();
    }
    public static AppImageCache getImageCache(){
        if (cache==null){
            cache=new AppImageCache();
        }
        return cache;
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public LruCache<String,Bitmap> getLruCache(){
        if (cache==null){
            //动态获取最大缓存
            int maxMemory= (int) Runtime.getRuntime().maxMemory();
            int maxSize=maxMemory/8;
            lruCache=new LruCache<String,Bitmap>(maxSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getHeight();
                }
            };
        }
        return lruCache;
    }
    @Override
    public Bitmap getBitmap(String s) {
        return getLruCache().get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        getLruCache().put(s,bitmap);
    }
}
