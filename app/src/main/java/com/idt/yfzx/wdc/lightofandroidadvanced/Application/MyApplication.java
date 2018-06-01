package com.idt.yfzx.wdc.lightofandroidadvanced.Application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.crash.CrashHandler;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.crash.MyActivityLifecycleCallbacks;

/**
 * Created by 王大川 on 2018-03-12.
 */

public class MyApplication extends Application {
    private MyActivityLifecycleCallbacks callback  ;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);//fresco 初始化 只能在全局application中初始化
        callback  = new MyActivityLifecycleCallbacks();
        this.registerActivityLifecycleCallbacks(callback);
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this,callback);

    }


}
