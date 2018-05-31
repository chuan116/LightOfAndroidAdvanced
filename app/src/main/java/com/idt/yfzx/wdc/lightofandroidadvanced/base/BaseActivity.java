package com.idt.yfzx.wdc.lightofandroidadvanced.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto.BusProvider;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;

import butterknife.ButterKnife;

/**
 * @author 王大川
 * @createTime 2018/5/29
 * <p>
 * description：BaseActivity
 * 1.butterknife 绑定
 * 2.otto 注册
 * 3.注册eventbus
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeInitial();
        //注册butterknife 绑定
        ButterKnife.bind(this);
        //订阅otto事件
        BusProvider.getInstance().register(this);
        EventBus.getDefault().register(this);
        onAfterInitial();
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();

    }

    //在进行页面初始化之前
    protected abstract void onBeforeInitial();

    //在进行页面初始化之后
    protected abstract void onAfterInitial();




}


