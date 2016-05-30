package com.gz.rentapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.gz.rentapp.R;
import com.gz.rentapp.adapter.DescAdapter;
import com.gz.rentapp.bean.DescEntiy;
import com.gz.rentapp.ui.DescdetalActivity;
import com.gz.rentapp.utils.GsonRequest;
import com.gz.rentapp.utils.VolleyHelper;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineFragment extends Fragment {
    private static final String TAG = "qianfeng";
    private GridView gridView;
    private List<DescEntiy> list;
    private DescEntiy descEntiy;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            DescAdapter descAdapter = new DescAdapter(getActivity(),list);
            gridView.setAdapter(descAdapter);
        }
    };
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line,null);
        gridView = ((GridView) view.findViewById(R.id.gridView));
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://chanyouji.com/api/destinations.json").build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(com.squareup.okhttp.Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG, "onResponse() returned: " + string);
                parseJson(string);
                handler.sendEmptyMessage(0);
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),DescdetalActivity.class);
                intent.putExtra("id",list.get(position).getId());
                startActivity(intent);
            }
        });
        return view ;
    }

    private void parseJson(String string) {
        list  = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(string);
            for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObject = jsonArray.getJSONObject(i);
                 String category = jsonObject.getString("category");
                 if("999".equals(category)){
                        JSONArray destinations = jsonObject.getJSONArray("destinations");
                     for (int j = 0;j < destinations.length();j++) {
                                 JSONObject data = destinations.getJSONObject(j);
                                 String id = data.getInt("id")+"";
                                 String name_zh_cn = data.getString("name_zh_cn");
                                 String name_en = data.getString("name_en");
                                 String poi_count = data.getInt("poi_count")+"";
                                 String lat = data.getDouble("lat")+"";
                                 String lngv = data.getDouble("lng")+"";
                                 String image_url = data.getString("image_url");
                                 String updated_at  = data.getLong("updated_at")+"";
                                 descEntiy = new DescEntiy(id,name_zh_cn,name_en,poi_count,lat,lngv,image_url,updated_at);
                                 list.add(descEntiy);
                     }
                 }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
