package com.gz.rentapp.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gz.rentapp.R;
import com.gz.rentapp.adapter.DetalAdapter;
import com.gz.rentapp.bean.DescEntiy;
import com.gz.rentapp.bean.DetalBean;
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

public class DescdetalActivity extends AppCompatActivity {

    private static final String TAG = "qianfeng";
    private ListView listView;
    private List<DetalBean> detalBeanList;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            DetalAdapter detalAdapter = new DetalAdapter(detalBeanList,DescdetalActivity.this);
            listView.setAdapter(detalAdapter);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descdetal);
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        Log.d(TAG, "onCreate() returned: " + id);
        //String id1 = intent.getStringExtra("id");
        String strUrl = "http://chanyouji.com/api/destinations/"+id+".json";
        Log.d(TAG, "onCreate() returned: " + strUrl);
        listView = ((ListView) findViewById(R.id.listview));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(strUrl).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }
            @Override
            public void onResponse(Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG, "onResponse() returned: " + string);
                parseJson(string);
                handler.sendEmptyMessage(0);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent1 = new Intent(DescdetalActivity.this,CityDtealActivity.class);
                    int id1 = detalBeanList.get(position).getId();
                    intent1.putExtra("id",id1);
                     startActivity(intent1);
            }
        });
    }
    private void parseJson(String string) {
        detalBeanList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(string);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name_zh_cn = jsonObject.getString("name_zh_cn");
                String name_en = jsonObject.getString("name_en");
                int poi_count = jsonObject.getInt("poi_count");
                int plans_count = jsonObject.getInt("plans_count");
                int articles_count = jsonObject.getInt("articles_count");
                int contents_count = jsonObject.getInt("contents_count");
                int destination_trips_count = jsonObject.getInt("destination_trips_count");
                boolean locked = jsonObject.getBoolean("locked");
                boolean wiki_app_publish = jsonObject.getBoolean("wiki_app_publish");
                long updated_at = jsonObject.getLong("updated_at");
                String image_url = jsonObject.getString("image_url");
                int guides_count = jsonObject.getInt("guides_count");
                DetalBean detalBean = new DetalBean(id,name_zh_cn,name_en,poi_count,plans_count,articles_count,contents_count,
                        destination_trips_count,locked,wiki_app_publish,updated_at,image_url,guides_count);
                detalBeanList.add(detalBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
