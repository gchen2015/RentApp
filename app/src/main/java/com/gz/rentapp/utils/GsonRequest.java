package com.gz.rentapp.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.gz.rentapp.db.JsonDb;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/11.
 */
public class GsonRequest<T> extends Request<T> {
    private Map<String, String> map;
    private Response.Listener<T> listener;
    private Gson gson;
    private Class<T> tClass;

    public GsonRequest(int method, String url,Class<T> tClass1,Response.Listener<T> listener, Response.ErrorListener errorlistener) {
        super(method, url, errorlistener);
        gson=new Gson();
        this.tClass=tClass1;
        this.listener=listener;
    }
    public GsonRequest(int method, String url,Class<T> tClass1,Map<String,String> map,Response.Listener<T> listener, Response.ErrorListener errorlistener) {
        this(method,url,tClass1,listener,errorlistener);
        gson=new Gson();
        this.tClass=tClass1;
        this.listener=listener;
        this.map=map;
    }
    public GsonRequest(String url,Class<T> clazz,Response.Listener<T> listener,Response.ErrorListener errorListener){
        this(Method.POST,url,clazz,listener,errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("X-AUTH-HEADER", JsonDb.token);
        headers.put("X-ATTA-APPID", JsonDb.appId);
        return headers;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String jsonString =new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(gson.fromJson(jsonString,tClass),HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }catch (IllegalStateException e){//解析异常
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T t) {
        listener.onResponse(t);
    }
}
