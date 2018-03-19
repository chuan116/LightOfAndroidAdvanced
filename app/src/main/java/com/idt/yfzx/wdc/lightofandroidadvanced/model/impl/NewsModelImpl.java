package com.idt.yfzx.wdc.lightofandroidadvanced.model.impl;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.NewsItemEntity;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.Trailers;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.NewsModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王大川 on 2018-03-15.
 */
public class NewsModelImpl implements NewsModel {
    Trailers result_list = null;

    @Override
    public void getTopNewsList(Context context, final OnNewsLoadListener onWeatherLoadListener) {

        // 1 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        // 2 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            // 正确接收数据回调
            @Override
            public void onResponse(String s) {
                resloveJson(s);
                onWeatherLoadListener.onSuccess(result_list);
            }
        }, new Response.ErrorListener() {// 发生异常后的监听回调
            @Override
            public void onErrorResponse(VolleyError volleyError) {
//               onWeatherLoadListener.onFail(result_list);
            }
        });
        // 3 将创建的请求添加到请求队列中
        requestQueue.add(stringRequest);
    }


    public void resloveJson(String s) {
        Gson gson = new Gson();
        result_list = gson.fromJson(s, Trailers.class);

    }


}
