package com.gz.rentapp.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.adapter.ImagePagerAdapter;
import com.gz.rentapp.adapter.ImageViewPager;
import com.gz.rentapp.adapter.IndexClassAdapter;
import com.gz.rentapp.adapter.QiTripAdapter;
import com.gz.rentapp.bean.AccessData;
import com.gz.rentapp.bean.AccexssBean;
import com.gz.rentapp.bean.IamgeBean;
import com.gz.rentapp.bean.QIzhouBean;
import com.gz.rentapp.bean.QiData;
import com.gz.rentapp.db.JsonUtil;
import com.gz.rentapp.db.QiZhouDb;
import com.gz.rentapp.ui.ItemDetailActivity;
import com.gz.rentapp.utils.GsonRequest2;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.view.AutoScrollViewPager;
import com.gz.rentapp.view.MyGridView;
import com.gz.rentapp.view.MyListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private PullToRefreshScrollView refreshScrollView;
    private List<Integer> integers=new ArrayList<>();
    private List<SimpleDraweeView> banner=new ArrayList<>();
    private AutoScrollViewPager recyclerView ;
    private MyListView myListView;
    private MyGridView gridView;
    private IndexClassAdapter indexClassAdapter;
    private RequestQueue mQueue;
    private List<QiData> qiDatas=new ArrayList<>();
    private QiTripAdapter qiTripAdapter;
    private ImagePagerAdapter adapter;
    private List<String> iamgeBeans=new ArrayList<>();
    private List<String> ImageIds=new ArrayList<>();
    private LinearLayout dotLL;
    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_index, container, false);
        mQueue= Volley.newRequestQueue(getActivity());
        init(view);
        initData();
        return view;
    }
    private void init(View view){
        dotLL= (LinearLayout) view.findViewById(R.id.home_dot_ll);
        refreshScrollView= (PullToRefreshScrollView) view.findViewById(R.id.scrollView);
        //listView
        myListView = (MyListView) view.findViewById(R.id.listView);
        //gridView
        gridView= (MyGridView) view.findViewById(R.id.gridView);
        integers.add(R.drawable.drawer_list_icon_hongkong);
        integers.add(R.drawable.drawer_list_icon_maldives);
        integers.add(R.drawable.drawer_icon_home_selected);
        integers.add(R.drawable.drawer_list_icon_domestic);
        integers.add(R.drawable.drawer_list_icon_europe);
        integers.add(R.drawable.drawer_list_icon_nearby);
        indexClassAdapter=new IndexClassAdapter(integers,getActivity());
        gridView.setAdapter(indexClassAdapter);

        //recycleView
        recyclerView = (AutoScrollViewPager) view.findViewById(R.id.recycleView);
    }

    private void initData(){
        final AccessData accessData=new AccessData();
        accessData.setPartner_id(QiZhouDb.PARTNERID);
        accessData.setAccess_key(QiZhouDb.ACCESSKEY);
        accessData.setAccess_secret(QiZhouDb.ACCESSSREC);
        AccexssBean accexssBean=new AccexssBean();
        accexssBean.setAccess_token(accessData);
        String toJson=JsonUtil.toJson(accexssBean);
        Map<String,String> map2=new HashMap<>();
        map2.put("json",toJson);
        Log.e("json",toJson);
        Log.e("url",QiZhouDb.getLook()+"json="+toJson);
        GsonRequest2<QIzhouBean> gsonRequest = new GsonRequest2<QIzhouBean>(Request.Method.POST,
                QiZhouDb.getLook(), QIzhouBean.class,map2,
                new Response.Listener<QIzhouBean>() {
                    @Override
                    public void onResponse(QIzhouBean bean) {
                        if (bean.getStatus().getSucceed()==1){
                            qiDatas=bean.getData();
                            qiTripAdapter=new QiTripAdapter(qiDatas,getActivity());
                            myListView.setAdapter(qiTripAdapter);
                            for (int i=0;i<4;i++){
                                String simpleDraweeView=qiDatas.get(i+1+1).getImg().getUrl();
                                iamgeBeans.add(simpleDraweeView);
                                ImageIds.add(qiDatas.get(i+1+1).getGoods_id());
                            }
                            adapter = new ImagePagerAdapter(getActivity(),iamgeBeans, dotLL,ImageIds);
                            recyclerView.setAdapter(adapter);
                            adapter.refreshData(true);
                            recyclerView.setOnPageChangeListener(adapter);

                        }else if (bean.getStatus().getSucceed()==0){
                            Toast.makeText(getActivity(),"请求失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("bean", error.getMessage());

            }
        });
        mQueue.add(gsonRequest);
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        recyclerView.stopAutoScroll();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mQueue!=null){
            mQueue.cancelAll(getActivity());
        }
    }
}
