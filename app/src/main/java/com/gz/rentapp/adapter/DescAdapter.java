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

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public class DescAdapter extends BaseAdapter {
     private Context context;
     private List<DescEntiy> list;
     private LayoutInflater inflater;

    public DescAdapter(Context context, List<DescEntiy> list) {
        this.context = context;
        this.list = list;
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
        if(convertView==null){
                 holder = new ViewHolder();
                 convertView = inflater.inflate(R.layout.grid_item,null);
                 holder.city_name = ((TextView) convertView.findViewById(R.id.city_name));
                 holder.city_name_pin = ((TextView) convertView.findViewById(R.id.city_name_pin));
                 holder.city_total = ((TextView) convertView.findViewById(R.id.city_total));
                 holder.image_view = ((SimpleDraweeView) convertView.findViewById(R.id.image_view));
            convertView.setTag(holder);
        }else {
                 holder = (ViewHolder) convertView.getTag();
        }
        DescEntiy descEntiy = list.get(position);
        Uri uri = Uri.parse(descEntiy.getImage_url());
        holder.image_view.setImageURI(uri);
        holder.city_name.setText(descEntiy.getName_zh_cn());
        holder.city_name_pin.setText(descEntiy.getName_en());
        holder.city_total.setText(descEntiy.getPoi_count()+"个旅行地");
        return convertView;
    }
    class  ViewHolder{
        SimpleDraweeView image_view;
        TextView city_name,city_name_pin,city_total;
    }
}
