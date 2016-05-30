package com.gz.rentapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.CityEntity;

import java.util.List;

/**
 * Created by Administrator on 2016/5/29.
 */
public class CityAdapter extends BaseAdapter {
    private List<CityEntity> list;
    private Context context;
    private LayoutInflater inflater;

    public CityAdapter(List<CityEntity> list, Context context) {
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
        if (convertView==null){
              holder = new ViewHolder();
              convertView = inflater.inflate(R.layout.city_item,null);
              holder.back_iamge = ((SimpleDraweeView) convertView.findViewById(R.id.back_iamge));
              holder.content = ((TextView) convertView.findViewById(R.id.content));
              holder.day = ((TextView) convertView.findViewById(R.id.day));
              holder.name = ((TextView) convertView.findViewById(R.id.name));
              holder.total = ((TextView) convertView.findViewById(R.id.total));
              convertView.setTag(holder);
        }else {
              holder = (ViewHolder) convertView.getTag();
        }
        CityEntity cityEntity = list.get(position);
        Uri uri = Uri.parse(cityEntity.getImage_url());
        holder.back_iamge.setImageURI(uri);
        holder.total.setText(cityEntity.getPlan_nodes_count()+"个旅行地");
        holder.name.setText(cityEntity.getName());
        holder.day.setText(cityEntity.getPlan_days_count()+"");
        holder.content.setText(cityEntity.getDescription());
        return convertView;
    }
    class ViewHolder{
        SimpleDraweeView back_iamge;
        TextView name,day,total,content;
    }
}
