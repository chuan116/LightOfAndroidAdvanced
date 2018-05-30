package com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;
import com.squareup.otto.Subscribe;

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

public class OttoEntrance extends BaseActivity {


    @BindView(R.id.mbtn)
    Button mbtn;

    @Override
    protected void onBeforeInitial() {
        this.setContentView(R.layout.activity_otto_entrance);

    }

    @Override
    protected void onAfterInitial() {

    }


    @Subscribe
    public void subscribeEvent(EventData2 data) {
        Log.d("zxy", data.getContent());
        System.out.println("otto" + data.getContent());
    }
    @OnClick(R.id.mbtn)
    public void onViewClicked() {
//        Toast.makeText(this,"butterknife",Toast.LENGTH_SHORT).show();
//        this.startActivity(new Intent(this, OttoActivityB.class));
        getDatasync();
    }




    public void getDatasync(){
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象
        //异步，需要设置一个回调接口
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }
                EventData2 mEventData = new EventData2();
                mEventData.setContent(response.body().string());
                BusProvider.getInstance().post(mEventData);//发布事件
            }
        });
    }
}
