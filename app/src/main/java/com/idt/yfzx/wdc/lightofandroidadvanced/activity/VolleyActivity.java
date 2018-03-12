package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.view.SimpleDraweeView;
import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.VolleyBitmapCache;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {

    protected Button volleyGet;
    protected Button volleyPost;
    protected Button volleyJson;
    protected Button volleyImageRequest;
    protected Button volleyImageLader;
    protected Button netWorkImageView;
    protected ImageView volleyImage;
    protected SimpleDraweeView volleyImageNet;
    protected TextView volleyResult;
    protected LinearLayout activityMain;
    protected NetworkImageView ivVolleyNetworkimagview;
    protected Button goNewslist;

    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_volley);
        initView();
    }


    public void doGet(View view) {
        pd.show();
        // 1 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
// 2 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            // 正确接收数据回调
            @Override
            public void onResponse(String s) {
                volleyResult.setText(s);
                pd.dismiss();
            }
        }, new Response.ErrorListener() {// 发生异常后的监听回调
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyResult.setText("加载失败" + volleyError);
                pd.dismiss();
            }
        });
// 3 将创建的请求添加到请求队列中
        requestQueue.add(stringRequest);
    }

    private void initView() {
        volleyGet = (Button) findViewById(R.id.volley_get);
        volleyPost = (Button) findViewById(R.id.volley_post);
        volleyJson = (Button) findViewById(R.id.volley_json);
        volleyImageRequest = (Button) findViewById(R.id.volley_imageRequest);
        volleyImageLader = (Button) findViewById(R.id.volley_imageLader);
        netWorkImageView = (Button) findViewById(R.id.netWorkImageView);
        volleyImage = (ImageView) findViewById(R.id.volley_image);
        volleyImageNet = (SimpleDraweeView) findViewById(R.id.volley_imageNet);
        volleyResult = (TextView) findViewById(R.id.volley_result);
        activityMain = (LinearLayout) findViewById(R.id.activity_main);
        pd = new ProgressDialog(this);
        pd.setTitle("正在请求...");
        ivVolleyNetworkimagview = (NetworkImageView) findViewById(R.id.iv_volley_networkimagview);
        goNewslist = (Button) findViewById(R.id.go_newslist);
    }

    public void doPost(View view) {
        pd.show();
        // 1 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2 创建一个post请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                pd.dismiss();
                volleyResult.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyResult.setText("请求失败" + volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                //   map.put("value1","param1");
                return map;
            }
        };
        // 3 将post请求添加到队列中
        requestQueue.add(stringRequest);
    }


    public void doJson(View view) {
        // 1 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                volleyResult.setText(jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyResult.setText("请求失败" + volleyError);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        // 3 将创建的请求添加到请求队列中
        requestQueue.add(jsonObjectRequest);
    }


    public void doPic(View view) {
        // 1 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);

// 2 创建一个图片的请求
        String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                // 正确接收到图片
                volleyImage.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyImage.setImageResource(R.drawable.ic_launcher_foreground);
            }
        });
// 3 将请求添加到请求队列中
        requestQueue.add(imageRequest);
    }

    public void doImageLoader(View view) {
        // 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);

        ImageLoader imageLoader = new ImageLoader(requestQueue, new VolleyBitmapCache());

// 加载图片
        String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        ImageLoader.ImageListener imageListener = imageLoader.getImageListener(volleyImage, R.mipmap.pic_default, R.mipmap.pic_default);
        imageLoader.get(url, imageListener);
    }

    public void doNetworkImageView(View view) {

        // 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 创建一个Imageloader
        ImageLoader imageLoader = new ImageLoader(requestQueue, new VolleyBitmapCache());
        // 默认图片和异常图片设置
        ivVolleyNetworkimagview.setDefaultImageResId(R.mipmap.pic_default);
        ivVolleyNetworkimagview.setErrorImageResId(R.mipmap.pic_default);
        // 加载图片
        String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        ivVolleyNetworkimagview.setImageUrl(url, imageLoader);

    }


    public void setGoNewslist(View view){
        Intent intent = new Intent();
        intent.setClass(this, NewsList.class);
        this.startActivity(intent);

    }
}



