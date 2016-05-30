package com.gz.rentapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gz.rentapp.R;
import com.gz.rentapp.bean.Msg2;
import com.gz.rentapp.db.JsonDb;
import com.gz.rentapp.utils.IntentUtil;
import com.gz.rentapp.utils.SPUtiles;
import com.gz.rentapp.utils.VolleyHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;
import de.greenrobot.event.EventBus;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LoginActivity";
    private EditText username;
    private Button login;
    private ImageView qq;
    private ImageView wechat;
    private ImageView sinaweibo;
    private TextView other;
    private TextView register;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        queue = VolleyHelper.getInstance().getQueue();
        init();
    }

    /**
     * 初始化控件
     */
    private void init() {
        username = (EditText) findViewById(R.id.username);
        login = (Button) findViewById(R.id.login);
        register = ((TextView) findViewById(R.id.register));
        other = ((TextView) findViewById(R.id.other));
        qq = ((ImageView) findViewById(R.id.qq));
        wechat = ((ImageView) findViewById(R.id.wechat));
        sinaweibo = ((ImageView) findViewById(R.id.sinaweibo));

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        qq.setOnClickListener(this);
        wechat.setOnClickListener(this);
        sinaweibo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                login(username.getText().toString().trim());
                break;
            case R.id.register:
                register();
                break;
            case R.id.qq:
                QQ qq = new QQ(LoginActivity.this);
                authorize(qq);
                break;
            case R.id.wechat:
                Toast.makeText(LoginActivity.this, "服务未开通！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sinaweibo:
                SinaWeibo xinlang = new SinaWeibo(LoginActivity.this);
                authorize(xinlang);
                break;
            default:
                break;
        }
    }

    /**
     * 登录
     *
     * @param phone 手机号码
     */
    private void login(final String phone) {
        String url = String.format(JsonDb.USER_REGISTER_URL, "isMember");
        JSONObject object = new JSONObject();
        try {
            object.put("mobile", phone);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject object) {
                    try {
                        if (object.getInt("code") == 0) {
                            if (object.getBoolean("result")) {
                                EventBus.getDefault().post(new Msg2(100));
                                IntentUtil.go2Activity(LoginActivity.this, MainActivity.class, null);
                            } else {
                                Toast.makeText(LoginActivity.this, "请先注册！", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, object.getString("msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(LoginActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            queue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     */
    private void register() {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

                    //判断是否为会员
                    isMember(phone);
                }
            }
        });
        registerPage.show(LoginActivity.this);
    }

    /**
     * 是否会员
     *
     * @param phone 手机号码
     */
    private void isMember(final String phone) {
        String url = String.format(JsonDb.USER_REGISTER_URL, "isMember");
        JSONObject object = new JSONObject();
        try {
            object.put("mobile", phone);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject object) {
                    try {
                        if (object.getInt("code") == 0) {
                            if (object.getBoolean("result")) {
                                Toast.makeText(LoginActivity.this, "该号码已经注册，请直接登录！", Toast.LENGTH_SHORT).show();
                            } else {
                                register(phone);
                                Toast.makeText(LoginActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                                SPUtiles.setint(LoginActivity.this, phone, object.getInt("mebId"));
                            }
                        } else {
                            Toast.makeText(LoginActivity.this, object.getString("msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(LoginActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            queue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册
     *
     * @param phone 手机号码
     */
    private void register(final String phone) {
        String url = String.format(JsonDb.USER_REGISTER_URL, "regNew");
        JSONObject object = new JSONObject();
        try {
            object.put("mobile", phone);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject object) {
                    try {
                        if (object.getInt("code") == 0) {
                            Toast.makeText(LoginActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                            SPUtiles.setint(LoginActivity.this, phone, object.getInt("mebId"));
                        } else {
                            Toast.makeText(LoginActivity.this, object.getString("msg"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Toast.makeText(LoginActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            queue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第三方登录
     *
     * @param plat 第三方平台
     */
    private void authorize(Platform plat) {
        //判断指定平台是否已经完成授权
        if (plat.isAuthValid()) {
            String userId = plat.getDb().getUserId();
            if (userId != null) {
                IntentUtil.go2Activity(LoginActivity.this, MainActivity.class, null);
            }
        }
        plat.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d(TAG, "onComplete() returned: " + platform.getDb().getUserName());
                IntentUtil.go2Activity(LoginActivity.this, MainActivity.class, null);
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(LoginActivity.this, "登录取消！", Toast.LENGTH_SHORT).show();
            }
        });
        // true不使用SSO授权，false使用SSO授权
        plat.SSOSetting(true);
        //获取用户资料
        plat.showUser(null);
    }
}
