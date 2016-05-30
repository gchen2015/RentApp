package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.gz.rentapp.R;
import com.gz.rentapp.adapter.TextAdapter;
import com.gz.rentapp.bean.KKZCBean;
import com.gz.rentapp.db.JsonDb;
import com.gz.rentapp.utils.GsonRequest2;
import com.gz.rentapp.view.MyListView;

public class CarActivity extends FragmentActivity {
    private RequestQueue requestQueue;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        requestQueue= Volley.newRequestQueue(this);
        bundle=getIntent().getExtras();
        init();
    }
    private String carId;
    private void init(){
        if (bundle!=null){
            carId=bundle.getString("carId");
        }
        initData(carId);
    }
    private void initData(String carId){
        GsonRequest2<KKZCBean> gsonRequest = new GsonRequest2<KKZCBean>(Request.Method.GET,
                JsonDb.getTaxtDetail(carId), KKZCBean.class,
                new Response.Listener<KKZCBean>() {
                    @Override
                    public void onResponse(KKZCBean bean) {
                        if (bean.getCode().equals("200")){
                            Log.e("tr","chenggong");
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
    protected void onDestroy() {
        super.onDestroy();
        if (requestQueue!=null){
            requestQueue.cancelAll(this);
        }
    }

}
