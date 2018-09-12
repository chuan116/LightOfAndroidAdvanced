package com.idt.yfzx.wdc.lightofandroidadvanced.activity.Database;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.database.DBOpenHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContentProviderActivity extends AppCompatActivity {

    @BindView(R.id.edt_name) EditText edtName;
    @BindView(R.id.edt_sex) EditText edtSex;
    @BindView(R.id.edt_age) EditText edtAge;
    @BindView(R.id.btn_insert) Button btnInsert;
    @BindView(R.id.txt_content) TextView txtContent;
    @BindView(R.id.btn_query) Button btnQuery;
    Handler mUiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        ButterKnife.bind(this);
//        registObserver();

    }

    @OnClick(R.id.btn_insert) public void onViewClicked() {
        String name = edtName.getText().toString();
        String sex = edtSex.getText().toString();
        int age = Integer.valueOf(edtAge.getText().toString());
        insertBySqliteHelper(name, sex, age);
//        getByProvider();
    }

    private void getByProvider() {
        ContentResolver resolver = this.getContentResolver();
        Uri uri = Uri.parse("content://com.idt.yfzx.wdc.lightofandroidadvanced.MyProvider/user");
        Cursor cursor = resolver.query(uri, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String a = cursor.getString(cursor.getColumnIndex("name"));
            txtContent.append(a + "\n");
        }
    }

    private void insertBySqliteHelper(String name, String sex, int age) {
        String insert_sql = "insert into user values (null,'" + name + "','" + sex + "'," + age + ")";
        DBOpenHelper.getInstance().execSQL(insert_sql);
        Uri uri = Uri.parse("content://com.idt.yfzx.wdc.lightofandroidadvanced.MyProvider/user");
        this.getContentResolver().notifyChange(uri,null);
    }

    @OnClick(R.id.btn_query) public void onQueryClicked() {
        getByProvider();

    }


    private void registObserver() {
        Uri uri = Uri.parse("content://com.idt.yfzx.wdc.lightofandroidadvanced.MyProvider/user");
        ContentResolver mContentResolver = this.getContentResolver();
        mContentResolver.registerContentObserver(uri, true, new MyObserver(mUiHandler));
    }


    public class MyObserver extends ContentObserver {
        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public MyObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            System.out.println("receive change");
        }

        @Override public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            System.out.println("receive change");
        }
    }
}
