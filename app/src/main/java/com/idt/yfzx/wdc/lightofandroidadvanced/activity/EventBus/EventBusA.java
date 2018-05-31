package com.idt.yfzx.wdc.lightofandroidadvanced.activity.EventBus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto.BusProvider;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto.EventData2;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EventBusA extends BaseActivity {

    @BindView(R.id.jump)
    Button jump;
    @BindView(R.id.go_fetch)
    Button goFetch;

    @Override
    protected void onBeforeInitial() {
        setContentView(R.layout.activity_event_bus_activity);
    }

    @Override
    protected void onAfterInitial() {

    }


    @OnClick(R.id.jump)
    public void onViewClicked() {
        this.startActivity(new Intent(this, EventBusB.class));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ThreadCallBack(MessageEvent messageEvent) {
        System.out.println("messageEvent = [" + messageEvent + "]");


    }



    @OnClick(R.id.go_fetch)
    public void onfetchClicked() {
        getDatasync();
    }


    public void getDatasync(){
//        Request request = new Request.Builder()
//                .url("http://publicobject.com/helloworld.txt")
//                .build();
//        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
//        //异步，需要设置一个回调接口
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//                Headers responseHeaders = response.headers();
//                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
//                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//                MessageEvent messageEvent = new MessageEvent("s");
//                EventBus.getDefault().post(messageEvent);
//            }
//        });

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MessageEvent messageEvent = new MessageEvent("s");
                EventBus.getDefault().post(messageEvent);
            }
        }.start();
    }
}
