package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gz.rentapp.R;
import com.gz.rentapp.fragment.CollectFragment;
import com.gz.rentapp.fragment.IndexFragment;
import com.gz.rentapp.fragment.LineFragment;
import com.gz.rentapp.fragment.PersonFragment;
import com.gz.rentapp.utils.ActivityManager;
import com.gz.rentapp.utils.FragmentTabAdapter;

import java.util.ArrayList;
import java.util.List;
public class InfoActivity extends FragmentActivity {
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        bundle=getIntent().getExtras();
        if (bundle!=null){
            Toast.makeText(this,bundle.getInt("flag")+"",Toast.LENGTH_SHORT).show();
        }
    }

}
