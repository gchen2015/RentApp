package com.gz.rentapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
//作为一个公用的适配器
/**
 * Created by Administrator on 2016/5/21.
 */
public abstract class ConnAdapter<T> extends BaseAdapter {
    public List<T> list;
    public LayoutInflater inflater;
    public Context context;
    public ConnAdapter(List<T> list,Context context){
         this.list=list;
         this.context=context;
         inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size()>0 ? list.size(): 0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getConView(i,view,viewGroup);
    }
    public abstract View getConView(int i, View view, ViewGroup viewGroup);
}
