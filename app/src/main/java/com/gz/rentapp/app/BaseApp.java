package com.gz.rentapp.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.config.AutoLayoutConifg;

import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2016/5/21.
 */
public class BaseApp extends Application {
    public static BaseApp baseApp;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        baseApp = this;
        ShareSDK.initSDK(baseApp);
        SMSSDK.initSDK(this, "134387f17d0f7", "21a46f0de361a186c4345540fdbd4478");
//        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
//        //注意该方法要再setContentView方法之前实现
//        SDKInitializer.initialize(getApplicationContext());
        Fresco.initialize(this);
    }

    public static BaseApp getInstance() {
        if (baseApp == null) {
            baseApp = new BaseApp();
        }
        return baseApp;
    }
}
