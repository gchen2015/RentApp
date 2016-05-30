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
import com.gz.rentapp.bean.QiData;
import com.gz.rentapp.ui.ItemDetailActivity;
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
public class QiTripAdapter extends ConnAdapter<QiData>{

    public QiTripAdapter(List<QiData> list, Context context) {
        super(list, context);
    }

    @Override
    public View getConView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view=inflater.inflate(R.layout.item_trip,viewGroup,false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.teName.setText(list.get(i).getName());
        viewHolder.teTitle.setText(list.get(i).getGoods_brief());
        viewHolder.tePrice.setText(list.get(i).getShop_price());
        viewHolder.simpleDraweeView.setImageURI(Uri.parse(list.get(i).getImg().getUrl()));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("goodsId",list.get(i).getGoods_id());
                IntentUtil.go2Activity((Activity)context, ItemDetailActivity.class,bundle);
            }
        });
        return view;
    }
    public static class ViewHolder{
        private TextView teName,teTitle,tePrice;
        private SimpleDraweeView simpleDraweeView;
        public ViewHolder(View view){
            teName= (TextView) view.findViewById(R.id.name);
            teTitle= (TextView) view.findViewById(R.id.title);
            tePrice= (TextView) view.findViewById(R.id.price);
            simpleDraweeView= (SimpleDraweeView) view.findViewById(R.id.game_contentimage_view);
        }
    }
}
