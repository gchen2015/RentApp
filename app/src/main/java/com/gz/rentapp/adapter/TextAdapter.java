package com.gz.rentapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.KKZCList;
import com.gz.rentapp.db.JsonDb;
import com.gz.rentapp.ui.CarActivity;
import com.gz.rentapp.utils.IntentUtil;

import java.util.List;

/**
 * @Package com.gz.rentapp.adapter
 * @作 用:
 * @创 建 人: wuzhenyang
 * @日 期: 2016/5/29
 * @修 改 人:
 * @日 期:
 */
public class TextAdapter extends ConnAdapter<KKZCList>{

    public TextAdapter(List<KKZCList> list, Context context) {
        super(list, context);
    }

    @Override
    public View getConView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view=inflater.inflate(R.layout.item_text,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.textView1.setText("车型："+list.get(i).getCarName());
        viewHolder.textView2.setText("车牌号："+list.get(i).getPlateNum());
        viewHolder.textView3.setText("地区："+list.get(i).getAddress());
        viewHolder.textView4.setText("距离："+list.get(i).getDistanceNum());
        viewHolder.textView5.setText("价格："+list.get(i).getMoney());
        viewHolder.simpleDraweeView.setImageURI(Uri.parse(JsonDb.GETIMAGE+list.get(i).getImagePic()));
        viewHolder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("carId",list.get(i).getCarId());
                IntentUtil.go2Activity((Activity)context,CarActivity.class,bundle);
            }
        });
        return view;
    }
    public static class ViewHolder{
        private SimpleDraweeView simpleDraweeView;
        private TextView textView1,textView2,textView3,textView4,textView5;
        public ViewHolder(View view){
            simpleDraweeView= (SimpleDraweeView) view.findViewById(R.id.imageView);
             textView1= (TextView) view.findViewById(R.id.text1);
            textView2= (TextView) view.findViewById(R.id.text2);
            textView3= (TextView) view.findViewById(R.id.text3);
            textView4= (TextView) view.findViewById(R.id.text4);
            textView5= (TextView) view.findViewById(R.id.text5);
        }
    }
}
