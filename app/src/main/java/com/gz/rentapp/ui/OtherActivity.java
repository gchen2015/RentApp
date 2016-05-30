package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.gz.rentapp.R;
import com.gz.rentapp.adapter.TextAdapter;
import com.gz.rentapp.bean.KKZCBean;
import com.gz.rentapp.bean.KKZCList;
import com.gz.rentapp.bean.QIzhouBean2;
import com.gz.rentapp.bean.QiDetailData;
import com.gz.rentapp.db.JsonDb;
import com.gz.rentapp.db.QiZhouDb;
import com.gz.rentapp.utils.GsonRequest2;
import com.gz.rentapp.view.MyListView;

import java.util.ArrayList;
import java.util.List;

public class OtherActivity extends FragmentActivity {
    private RequestQueue requestQueue;
    private MyListView listView;
    private List<KKZCList> lists=new ArrayList<>();
    private TextAdapter textAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        requestQueue= Volley.newRequestQueue(this);
        init();
        initData();
    }
    private void init(){
        listView= (MyListView) findViewById(R.id.listView);
    }
    private void initData(){
        GsonRequest2<KKZCBean> gsonRequest = new GsonRequest2<KKZCBean>(Request.Method.GET,
                JsonDb.getTaxtList(), KKZCBean.class,
                new Response.Listener<KKZCBean>() {
                    @Override
                    public void onResponse(KKZCBean bean) {
                        if (bean.getCode().equals("200")){
                          lists=bean.getData().getListcar();
                          textAdapter=new TextAdapter(lists,OtherActivity.this);
                          listView.setAdapter(textAdapter);
                          textAdapter.notifyDataSetChanged();
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
