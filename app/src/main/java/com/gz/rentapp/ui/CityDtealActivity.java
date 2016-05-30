package com.gz.rentapp.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gz.rentapp.R;
import com.gz.rentapp.adapter.CityAdapter;
import com.gz.rentapp.bean.CityEntity;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityDtealActivity extends AppCompatActivity {

    private ListView listView;
    private List<CityEntity> list;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CityAdapter cityAdapter = new CityAdapter(list,CityDtealActivity.this);
            listView.setAdapter(cityAdapter);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_dteal);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        String str = "http://chanyouji.com/api/destinations/plans/"+id+".json?page=1";
        listView = ((ListView) findViewById(R.id.listview));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(str).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }
            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                parseJson(string);
                handler.sendEmptyMessage(0);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
    }
    private void parseJson(String string) {
        list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(string);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                int budget = jsonObject.getInt("budget");
                String description = jsonObject.getString("description");
                int plan_days_count = jsonObject.getInt("plan_days_count");
                int plan_nodes_count = jsonObject.getInt("plan_nodes_count");
                String image_url = jsonObject.getString("image_url");
                long updated_at = jsonObject.getLong("updated_at");
                CityEntity cityEntity = new CityEntity(id,name,budget,description,plan_days_count,plan_nodes_count,image_url,updated_at);
                list.add(cityEntity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
