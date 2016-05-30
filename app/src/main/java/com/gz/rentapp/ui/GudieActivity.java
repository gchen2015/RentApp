package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gz.rentapp.R;
import com.gz.rentapp.adapter.ImageRecycleAdapter;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.utils.SPUtiles;

import java.util.ArrayList;
import java.util.List;

public class GudieActivity extends AppCompatActivity {
    private DefaultItemAnimator animator;
    private RecyclerView recyclerView;
    private ImageRecycleAdapter imageRecycleAdapter;
    private List<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SPUtiles.getBoolean(getApplicationContext(), "guide")) {
            if (SPUtiles.getBoolean(getApplicationContext(), "guide")) {
                IntentUtil.go2Activity(GudieActivity.this, MainActivity.class, null);
                finish();
            }
        }
        setContentView(R.layout.activity_guide);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.gudieRecycle);
        list.add(R.mipmap.b4);
        list.add(R.mipmap.b3);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        animator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(animator);
        imageRecycleAdapter = new ImageRecycleAdapter(list, this);
        recyclerView.setAdapter(imageRecycleAdapter);
    }
}
