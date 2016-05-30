package com.gz.rentapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.gz.rentapp.R;

/**
 * Created by Administrator on 2016/5/29 0029.
 */
public class RecordActivity extends AppCompatActivity {

    private ListView lv;
    private TextView tv;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");

        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        lv = ((ListView) findViewById(R.id.lv));
        tv = ((TextView) findViewById(R.id.tv));
        lv.setEmptyView(tv);
    }
}
