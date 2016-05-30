package com.gz.rentapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.DescEntiy;
import com.gz.rentapp.bean.DetalBean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class DetalAdapter extends BaseAdapter {
    private List<DetalBean> list;
    private Context context;
    private LayoutInflater inflater;

    public DetalAdapter(List<DetalBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         ViewHolder holder;
        if(convertView ==null){
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.list_item,null);
                holder.back_iamge = ((SimpleDraweeView) convertView.findViewById(R.id.image_view));
                holder.city_name = ((TextView) convertView.findViewById(R.id.city_name));
                holder.city_name_pin = ((TextView) convertView.findViewById(R.id.city_name_pin));
                convertView.setTag(holder);
        }else {
                holder = (ViewHolder) convertView.getTag();
        }
        DetalBean detalBean = list.get(position);
        Uri uri = Uri.parse(detalBean.getImage_url());
        holder.back_iamge.setImageURI(uri);
        holder.city_name_pin.setText(detalBean.getName_zh_cn());
        holder.city_name.setText(detalBean.getName_en());
        return convertView;
    }
    class ViewHolder{
        SimpleDraweeView back_iamge;
        TextView city_name,city_name_pin;
    }
}
