package com.idt.yfzx.wdc.lightofandroidadvanced.activity.EventBus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusB extends BaseActivity {


    @BindView(R.id.jump)
    Button jump;

    @Override
    protected void onBeforeInitial() {
        setContentView(R.layout.activity_event_bus_b);
    }

    @Override
    protected void onAfterInitial() {

    }

    @OnClick(R.id.jump)
    public void onViewClicked() {
        MessageEvent messageEvent = new MessageEvent("s");
        EventBus.getDefault().post(messageEvent);
        this.finish();
    }
}
