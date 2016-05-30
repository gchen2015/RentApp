package com.gz.rentapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.bean.IamgeBean;
import com.gz.rentapp.ui.ItemDetailActivity;
import com.gz.rentapp.utils.IntentUtil;

import java.util.List;

/**
 * @Package com.gz.rentapp.adapter
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/28
 * @修 改 人:
 * @日 期:
 */
public class ImageViewPager extends PagerAdapter{
    private List<SimpleDraweeView> list;
    private Context context;
    private List<String> stringList;

    public ImageViewPager(List<SimpleDraweeView> list,List<String> strings,Context context){
        this.context=context;
        this.list=list;
        this.stringList=strings;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(list.get(position));
        list.get(position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("goodsId",stringList.get(position));
                IntentUtil.go2Activity((Activity)context, ItemDetailActivity.class, bundle);
            }
        });
        return list.get(position);
    }
}
