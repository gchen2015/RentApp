package com.gz.rentapp.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.Msg;
import com.gz.rentapp.fragment.IndexFragment;
import com.gz.rentapp.fragment.LineFragment;
import com.gz.rentapp.fragment.PersonFragment;
import com.gz.rentapp.utils.FragmentTabAdapter;
import com.gz.rentapp.utils.IntentUtil;
import com.iimedia.analytics.MobileClickAgent;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    private RequestQueue mQueue;
    private List<Fragment> fragments = new ArrayList<>();
    private RadioGroup radioGroup;
    private long mExitTime;//控制退出程序的时间间隔
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private void init() {
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        radioGroup = (RadioGroup) findViewById(R.id.mainGroud);
        fragments.add(new IndexFragment());
        fragments.add(new LineFragment());
        fragments.add(new PersonFragment());
        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(this, fragments, R.id.mainLayout, radioGroup);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.login:
                    IntentUtil.go2Activity(MainActivity.this, LoginActivity.class, null);
                    break;
                default:
                    break;
            }
            return true;
        }
    };

    //判断用户是否按home键退出程序，给出相应的提示
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onEventMainThread(Msg msg) {
        toolbar.setTitleTextColor(Color.WHITE);
        switch (msg.getId()) {
            case 0:
                toolbar.setTitle("发现");
//                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                toolbar.setTitle("目的地");
//                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                toolbar.setTitle("我的");
//                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onResume() {
        MobileClickAgent.onResume(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        MobileClickAgent.onPause(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
