package com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.impl;

import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.bean.EntranceBean;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.IModel;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author 王大川
 * @createTime 2018/5/31
 * <p>
 * description：
 */
public class EntranceModelmpl implements IModel{
    @Override
    public void getTopNewsList() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15566885957";
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody body = new FormBody.Builder()
//                .add("键", "值")
//                .add("键", "值")
                        .build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
//                    MessageEvent messageEvent = new MessageEvent(new EntranceBean(response.body().string());
                    EntranceBean  bean   = new EntranceBean(response.body().string());
                    EventBus.getDefault().post(bean);
                } catch (IOException e) {
                    e.printStackTrace();
                    EntranceBean  bean   = new EntranceBean("error");
                    EventBus.getDefault().post(bean);
                }
            }
        }.start();

    }
}
