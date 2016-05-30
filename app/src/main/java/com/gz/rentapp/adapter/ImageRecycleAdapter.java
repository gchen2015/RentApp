package com.gz.rentapp.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gz.rentapp.R;
import com.gz.rentapp.bean.GuideBean;
import com.gz.rentapp.ui.MainActivity;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.utils.SPUtiles;

import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 */
public class ImageRecycleAdapter extends RecyclerView.Adapter<ImageRecycleAdapter.MeViewHolder> {
    private List<Integer> list;
    private Activity context;
    private GuideBean guideBean = new GuideBean();

    public ImageRecycleAdapter(List<Integer> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    public static class MeViewHolder extends RecyclerView.ViewHolder {
        private Button goMail;
        private ImageView imageView;
        private TextView textView;

        public MeViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.gudieImage);
            textView = (TextView) itemView.findViewById(R.id.textContext);
            goMail = ((Button) itemView.findViewById(R.id.goMail));
        }
    }

    @Override
    public MeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_image, parent, false);
        MeViewHolder viewHolder = new MeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MeViewHolder holder, final int position) {
        holder.imageView.setBackgroundResource(list.get(position));
        if (position == 0) {
            holder.textView.setVisibility(View.VISIBLE);
        } else {
            holder.textView.setVisibility(View.GONE);
        }
        if (position == list.size() - 1) {
            holder.goMail.setVisibility(View.VISIBLE);
            holder.goMail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == list.size() - 1) {
                        SPUtiles.setBoolean(context, "guide", true);
                        IntentUtil.go2Activity(context, MainActivity.class, null);
                        context.finish();
                    }
                }
            });
        } else {
            holder.goMail.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() : 0;
    }
}
