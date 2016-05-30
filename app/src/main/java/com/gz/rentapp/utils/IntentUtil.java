package com.gz.rentapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.gz.rentapp.R;


/**
 * 页面跳转工具
 * 
 * @author Administrator
 * 
 */
public class IntentUtil {
	public static void go2Activity(Activity activity, Class<?> c, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(activity, c);
		if (null != bundle) {
			intent.putExtras(bundle);
		}
		activity.startActivity(intent);
		activity.overridePendingTransition(R.anim.push_left_in,
				R.anim.push_left_out);
	}
}
