package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.gz.rentapp.R;
import com.gz.rentapp.adapter.ImagePagerAdapter;
import com.gz.rentapp.bean.AccessData;
import com.gz.rentapp.bean.AccexssDetailBean;
import com.gz.rentapp.bean.QIzhouBean2;
import com.gz.rentapp.bean.QiDetailData;
import com.gz.rentapp.db.JsonUtil;
import com.gz.rentapp.db.QiZhouDb;
import com.gz.rentapp.utils.GsonRequest2;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.view.AutoScrollViewPager;
import com.gz.rentapp.view.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ItemDetailActivity extends FragmentActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private TextView name,context,update,price,realPrice,briefValue,tiTitle,haBanInfo;

    private Button inOrder;
    private CheckBox checkBox1,checkBox2,checkBox3;
    private AutoScrollViewPager autoScrollViewPager;
    private LinearLayout linearLayout;
    private List<String> imageList=new ArrayList<>();

    private Bundle bundle;
    private String string;
    private RequestQueue requestQueue;
    private ImagePagerAdapter imagePagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_class);
        requestQueue= Volley.newRequestQueue(this);
        bundle=getIntent().getExtras();
        init();
        initData();
    }
    private void init(){
        if (bundle!=null){
            string=bundle.getString("goodsId");
        }
        checkBox1= (CheckBox) findViewById(R.id.r1);
        checkBox2= (CheckBox) findViewById(R.id.r2);
        checkBox3= (CheckBox) findViewById(R.id.r3);
        haBanInfo= (TextView) findViewById(R.id.hanbapi);
        linearLayout= (LinearLayout) findViewById(R.id.home_dot_ll);
        name= (TextView) findViewById(R.id.name);
        context= (TextView) findViewById(R.id.context);
        update= (TextView) findViewById(R.id.update);
        price= (TextView) findViewById(R.id.price);
        realPrice= (TextView) findViewById(R.id.realPrice);
        inOrder= (Button) findViewById(R.id.inOrder);
        briefValue= (TextView) findViewById(R.id.muListView);
        tiTitle= (TextView) findViewById(R.id.xinListView);
        autoScrollViewPager= (AutoScrollViewPager) findViewById(R.id.home_banner_viewpager);
        imagePagerAdapter=new ImagePagerAdapter(this,imageList,linearLayout,null);
        autoScrollViewPager.setAdapter(imagePagerAdapter);
        autoScrollViewPager.setOnPageChangeListener(imagePagerAdapter);
        inOrder.setOnClickListener(this);
        haBanInfo.setOnClickListener(this);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
    }
    private void initData(){
        AccessData accessData=new AccessData();
        accessData.setPartner_id(QiZhouDb.PARTNERID);
        accessData.setAccess_key(QiZhouDb.ACCESSKEY);
        accessData.setAccess_secret(QiZhouDb.ACCESSSREC);
        AccexssDetailBean accexssBean=new AccexssDetailBean();
        accexssBean.setGoods_id(string);
        accexssBean.setAccess_token(accessData);
        String toJson= JsonUtil.toJson(accexssBean);
        Map<String,String> map2=new HashMap<>();
        map2.put("json",toJson);
        Log.e("json", toJson);
        GsonRequest2<QIzhouBean2> gsonRequest = new GsonRequest2<QIzhouBean2>(Request.Method.POST,
                QiZhouDb.getService(), QIzhouBean2.class,map2,
                new Response.Listener<QIzhouBean2>() {
                    @Override
                    public void onResponse(QIzhouBean2 bean) {
                        if (bean.getStatus().getSucceed()==1){
                             QiDetailData qiDetailData=bean.getData();
                             //设置普通view数据
                            briefValue.setText(qiDetailData.getBrief().get(0).getValue());
                            tiTitle.setText(qiDetailData.getBrief().get(0).getValue());
                             name.setText(qiDetailData.getGoods_name());
                             context.setText("标题内容 ："+qiDetailData.getGoods_brief());
                             price.setText("价格："+qiDetailData.getMarket_price());
                             realPrice.setText("原价格:"+ qiDetailData.getShop_price());
                             update.setText("更新日期 ："+qiDetailData.getLast_update());
                             for (int i=0;i<qiDetailData.getPictures().size();i++){
                                 imageList.add(qiDetailData.getPictures().get(i).getUrl());
                             }
                            imagePagerAdapter.refreshData(true);
                            autoScrollViewPager.setOnPageChangeListener(imagePagerAdapter);


                        }else if (bean.getStatus().getSucceed()==0){

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("bean", error.getMessage());

            }
        });
        requestQueue.add(gsonRequest);

    }
    @Override
    public void onResume() {
        super.onResume();
        autoScrollViewPager.startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        autoScrollViewPager.stopAutoScroll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (requestQueue!=null){
            requestQueue.cancelAll(this);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton==checkBox1){
                Toast.makeText(ItemDetailActivity.this,"1",Toast.LENGTH_SHORT).show();
            }else if (compoundButton==checkBox2){
                Toast.makeText(ItemDetailActivity.this,"2",Toast.LENGTH_SHORT).show();
            }else {
                IntentUtil.go2Activity(ItemDetailActivity.this,OtherActivity.class,null);
            }
    }
}
