package com.idt.yfzx.wdc.lightofandroidadvanced.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.idt.yfzx.wdc.lightofandroidadvanced.Application.MyApplication;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test_demo.db";//数据库文件名
    public static final String TABLENAME = "user";
    private static SQLiteDatabase INSTANCE;
    private Context mContext;

    public static SQLiteDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DBOpenHelper(MyApplication.appContext).getWritableDatabase();
        }
        return INSTANCE;
    }

    public DBOpenHelper(Context context) {
        this(context, DB_NAME, null, 1);
        this.mContext = context;
    }

    public DBOpenHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABLENAME + "(_id integer NOT NULL PRIMARY KEY AUTOINCREMENT," + " name text, " + " sex text, " + " age integer);";
        //创建表
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}


