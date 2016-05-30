package com.gz.rentapp.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.Msg2;
import com.gz.rentapp.ui.LoginActivity;
import com.gz.rentapp.ui.RecordActivity;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.utils.SPUtiles;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment implements View.OnClickListener {
    private SimpleDraweeView avatar;
    private TextView username;
    private int mebId;
    private TextView tv_car;
    private TextView tv_re_car;
    private TextView tv_trip;
    private TextView tv_re_trip;
    private ImageView iv_car;
    private ImageView iv_re_car;
    private ImageView iv_trip;
    private ImageView iv_re_trip;
    private Bundle bundle;
    private TextView tv_settings;
    private TextView tv_phone;
    private ImageView iv_settings;
    private ImageView iv_phone;
    private AutoRelativeLayout p1, p2, p3, p4, p5, p6;
    private AlertDialog dialog;

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initView(View view) {
        avatar = ((SimpleDraweeView) view.findViewById(R.id.avatar));
        username = ((TextView) view.findViewById(R.id.username));
        mebId = SPUtiles.getInt(getActivity(), "mebId");
        tv_car = ((TextView) view.findViewById(R.id.tv_car));
        tv_re_car = ((TextView) view.findViewById(R.id.tv_re_car));
        tv_trip = ((TextView) view.findViewById(R.id.tv_trip));
        tv_re_trip = ((TextView) view.findViewById(R.id.tv_re_trip));
        iv_car = ((ImageView) view.findViewById(R.id.iv_car));
        iv_re_car = ((ImageView) view.findViewById(R.id.iv_re_car));
        iv_trip = ((ImageView) view.findViewById(R.id.iv_trip));
        iv_re_trip = ((ImageView) view.findViewById(R.id.iv_re_trip));
        tv_settings = ((TextView) view.findViewById(R.id.tv_settings));
        tv_phone = ((TextView) view.findViewById(R.id.tv_phone));
        iv_settings = ((ImageView) view.findViewById(R.id.iv_settings));
        iv_phone = ((ImageView) view.findViewById(R.id.iv_phone));
        p1 = ((AutoRelativeLayout) view.findViewById(R.id.p1));
        p2 = ((AutoRelativeLayout) view.findViewById(R.id.p2));
        p3 = ((AutoRelativeLayout) view.findViewById(R.id.p3));
        p4 = ((AutoRelativeLayout) view.findViewById(R.id.p4));
        p5 = ((AutoRelativeLayout) view.findViewById(R.id.p5));
        p6 = ((AutoRelativeLayout) view.findViewById(R.id.p6));

        tv_car.setOnClickListener(this);
        tv_re_car.setOnClickListener(this);
        tv_trip.setOnClickListener(this);
        tv_re_trip.setOnClickListener(this);
        iv_car.setOnClickListener(this);
        iv_re_car.setOnClickListener(this);
        iv_trip.setOnClickListener(this);
        iv_re_trip.setOnClickListener(this);
        tv_settings.setOnClickListener(this);
        tv_phone.setOnClickListener(this);
        iv_settings.setOnClickListener(this);
        iv_phone.setOnClickListener(this);
        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        p4.setOnClickListener(this);
        p5.setOnClickListener(this);
        p6.setOnClickListener(this);

        if (mebId != 0) {
            username.setText("会员" + mebId);
        } else {
            username.setText("登录/注册");
        }
        avatar.setOnClickListener(this);
        username.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        bundle = new Bundle();
        switch (view.getId()) {
            case R.id.username:
                if (mebId == 0) {
                    IntentUtil.go2Activity(getActivity(), LoginActivity.class, null);
                } else {
                    dialog = new AlertDialog.Builder(getActivity()).setTitle("账号管理").setCancelable(false)
                            .setMessage("退出登录？").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    SPUtiles.setint(getActivity(), "mebId", 0);
                                    username.setText("登录/注册");
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }
            case R.id.avatar:
                if (mebId == 0) {
                    IntentUtil.go2Activity(getActivity(), LoginActivity.class, null);
                }
                break;
            case R.id.tv_car:
                bundle.putString("title", tv_car.getText().toString().toString());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.tv_re_car:
                bundle.putString("title", tv_re_car.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.tv_trip:
                bundle.putString("title", tv_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.tv_re_trip:
                bundle.putString("title", tv_re_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.iv_car:
                bundle.putString("title", tv_car.getText().toString().toString());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.iv_re_car:
                bundle.putString("title", tv_re_car.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.iv_trip:
                bundle.putString("title", tv_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.iv_re_trip:
                bundle.putString("title", tv_re_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.tv_settings:
                dialog = new AlertDialog.Builder(getActivity()).setTitle("个人设置").setCancelable(false)
                        .setMessage("清除记录？").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "清除记录成功", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.iv_settings:
                dialog = new AlertDialog.Builder(getActivity()).setTitle("个人设置").setCancelable(false)
                        .setMessage("清除记录？").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "清除记录成功", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.tv_phone:
                dialog = new AlertDialog.Builder(getActivity()).setTitle(tv_phone.getText().toString().trim()).setCancelable(false)
                        .setMessage("小吴：110").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.iv_phone:
                dialog = new AlertDialog.Builder(getActivity()).setTitle(tv_phone.getText().toString().trim()).setCancelable(false)
                        .setMessage("小吴：110").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.p1:
                bundle.putString("title", tv_car.getText().toString().toString());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.p2:
                bundle.putString("title", tv_re_car.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.p3:
                bundle.putString("title", tv_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.p4:
                bundle.putString("title", tv_re_trip.getText().toString().trim());
                IntentUtil.go2Activity(getActivity(), RecordActivity.class, bundle);
                break;
            case R.id.p5:
                dialog = new AlertDialog.Builder(getActivity()).setTitle("个人设置").setCancelable(false)
                        .setMessage("清除记录？").setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "清除记录成功", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            case R.id.p6:
                dialog = new AlertDialog.Builder(getActivity()).setTitle(tv_phone.getText().toString().trim()).setCancelable(false)
                        .setMessage("小吴：110").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
                break;
            default:
                break;
        }
    }

    public void onEventMainThread(Msg2 msg) {
        switch (msg.getTitle()) {
            case 100:
                Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
                mebId = SPUtiles.getInt(getActivity(), "mebId");
                username.setText("会员" + mebId);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
