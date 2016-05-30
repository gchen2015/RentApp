package com.gz.rentapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gz.rentapp.R;
import com.gz.rentapp.ui.ItemClassActivity;
import com.gz.rentapp.utils.IntentUtil;

import java.util.List;

/**
 * @Package com.gz.rentapp.adapter
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/27
 * @修 改 人:
 * @日 期:
 */
public class IndexClassAdapter extends ConnAdapter<Integer>{
    private String str=null;
    public IndexClassAdapter(List<Integer> list, Context context) {
        super(list, context);
    }

    @Override
    public View getConView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
           view=inflater.inflate(R.layout.item_index_classify,viewGroup,false);
           viewHolder=new ViewHolder(view);
           view.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setBackgroundResource(list.get(i));
        if (i==0){
            str="航班";
        }else if(i==1){
            str="目的地";
        }else if(i==2){
            str="酒店";
        }else if(i==3){
            str="附近";
        }else if(i==4){
            str="观光";
        }else if(i==5){
            str="出租车";
        }
        viewHolder.textView.setText(str);
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putInt("position",i);
                IntentUtil.go2Activity((Activity)context,ItemClassActivity.class,bundle);
            }
        });

        return view;
    }
    public static class ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View view){
            imageView= (ImageView) view.findViewById(R.id.imageView);
            textView= (TextView) view.findViewById(R.id.textView);
        }
    }
}
