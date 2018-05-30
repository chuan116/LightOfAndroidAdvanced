package com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto;


import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;
import com.squareup.otto.Produce;

public class OttoActivityB extends BaseActivity {

    @Override
    protected void onBeforeInitial() {
        setContentView(R.layout.activity_otto_b);
    }

    @Override
    protected void onAfterInitial() {

    }

//    @Produce
//    public EventData2 produceEvent() {
//        EventData2 mEventData = new EventData2();
//        mEventData.setContent("hello word!");
//        return mEventData;
//    }



}
