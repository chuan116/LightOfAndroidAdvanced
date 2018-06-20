package com.idt.yfzx.wdc.lightofandroidadvanced.Application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.idt.yfzx.wdc.lightofandroidadvanced.BuildConfig;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.crash.CrashHandler;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.crash.MyActivityLifecycleCallbacks;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.DaoMaster;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.DaoSession;

/**
 * Created by 王大川 on 2018-03-12.
 */

public class MyApplication extends Application {
    private MyActivityLifecycleCallbacks callback;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);//fresco 初始化 只能在全局application中初始化
        callback = new MyActivityLifecycleCallbacks();
        this.registerActivityLifecycleCallbacks(callback);
        if (!BuildConfig.DEBUG) {
            CrashHandler crashHandler = CrashHandler.getInstance();
            crashHandler.init(this, callback);
        }
        setDatabase();
    }

    public static MyApplication getInstances() {
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}


