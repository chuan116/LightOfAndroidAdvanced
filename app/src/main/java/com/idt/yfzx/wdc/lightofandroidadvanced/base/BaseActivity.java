package com.idt.yfzx.wdc.lightofandroidadvanced.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author 王大川
 * @createTime 2018/5/29
 * <p>
 * description：BaseActivity
 * 1.butterknife 绑定
 */
public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeInitial();
        //填绑定内容
        ButterKnife.bind(this);
        onAfterInitial();
    }





    //在进行页面初始化之前
    protected abstract void onBeforeInitial();

    //在进行页面初始化之后
    protected abstract void onAfterInitial();
}


