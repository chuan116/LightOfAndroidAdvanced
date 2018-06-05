package com.idt.yfzx.wdc.lightofandroidadvanced.TouTiao.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto.BusProvider;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

/**
 * @author 王大川
 * @createTime 2018/6/5
 * <p>
 * description：
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        onBeforeInitial();
        //注册butterknife 绑定
        ButterKnife.bind(this);
        //订阅eventbus事件
        EventBus.getDefault().register(this);
        onAfterInitial();
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();

    }

    //在进行页面初始化之前
    protected abstract void onBeforeInitial();

    //在进行页面初始化之后
    protected abstract void onAfterInitial();


}
