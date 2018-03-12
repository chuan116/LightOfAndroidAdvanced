package com.idt.yfzx.wdc.lightofandroidadvanced.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

import com.idt.yfzx.wdc.lightofandroidadvanced.MainActivity;

/**
 * Created by 王大川 on 2018-03-08.
 */

public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //pdus短信单位pdu
        //解析短信内容
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        for (Object pdu : pdus) {
            //封装短信参数的对象
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
            String number = sms.getOriginatingAddress();
            String body = sms.getMessageBody();
            //写自己的处理逻辑
        }

        Intent  targetIntent  = new Intent();
        targetIntent.setClass(context, MainActivity.class);
        context.startActivity(targetIntent);
    }
}
