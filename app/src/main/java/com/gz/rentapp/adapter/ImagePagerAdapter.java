package com.gz.rentapp.adapter;

/**
 * @Package com.qianfeng.zw.demo.adpter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/4/7 14:15
 * @修 改 人:
 * @日 期:
 */

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.ui.ItemDetailActivity;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.view.RecyclingPagerAdapter;

import java.util.List;

/**
 * ImagePagerAdapter
 */
public class ImagePagerAdapter extends RecyclingPagerAdapter implements ViewPager.OnPageChangeListener {

    private Context context;
    private List<String> iamgeUrls;
    private boolean isInfiniteLoop;
    //圆点的父布局
    private LinearLayout dotLL;
    private List<String> stringList;

    public ImagePagerAdapter(Context context, List<String> iamgeUrls, LinearLayout dotLL,List<String> strings) {
        this.context = context;
        this.iamgeUrls = iamgeUrls;
        isInfiniteLoop = false;
        this.dotLL = dotLL;
        this.stringList=strings;

    }

    @Override
    public int getCount() {
        return isInfiniteLoop ? Integer.MAX_VALUE : iamgeUrls.size();
    }

    /**
     * get really position
     *
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % iamgeUrls.size() : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = holder.imageView = new SimpleDraweeView(context);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.imageView.setImageURI(Uri.parse(iamgeUrls.get(getPosition(position))));
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stringList==null){}else {
                    Bundle bundle=new Bundle();
                    bundle.putString("goodsId",stringList.get(position%4));
                    IntentUtil.go2Activity((Activity) context, ItemDetailActivity.class, bundle);
                }
            }
        });
        return view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < iamgeUrls.size(); i++) {
            if (getPosition(position) == i) {
                ((ImageView) dotLL.getChildAt(i)).setImageResource(R.drawable.dot_press);
            } else {
                ((ImageView) dotLL.getChildAt(i)).setImageResource(R.drawable.dot_nomal);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private static class ViewHolder {
        SimpleDraweeView imageView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }

    public void refreshData(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        this.notifyDataSetChanged();
        addDotView();
    }

    /**
     * 动态添加小圆点
     */
    private void addDotView() {
        for (int i = 0; i < iamgeUrls.size(); i++) {
            ImageView dotView = new ImageView(context);
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            param.rightMargin = 5;
            dotView.setLayoutParams(param);
            if (i == 0) {
                dotView.setImageResource(R.drawable.dot_press);
            } else {
                dotView.setImageResource(R.drawable.dot_nomal);
            }
            dotLL.addView(dotView);
        }
    }

}
