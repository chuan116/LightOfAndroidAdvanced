package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RemoteViews;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btnNormal;
    protected Button btnFoldable;
    protected Button btnHangable;
    protected RadioButton rbPublic;
    protected RadioButton rbPrivate;
    protected RadioButton rbSecret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_notification);
        initView();
    }

    private void initView() {
        btnNormal = (Button) findViewById(R.id.btn_normal);
        btnNormal.setOnClickListener(this);
        btnFoldable = (Button) findViewById(R.id.btn_foldable);
        btnFoldable.setOnClickListener(this);
        btnHangable = (Button) findViewById(R.id.btn_hangable);
        btnHangable.setOnClickListener(this);
        rbPublic = (RadioButton) findViewById(R.id.rb_public);
        rbPrivate = (RadioButton) findViewById(R.id.rb_private);
        rbSecret = (RadioButton) findViewById(R.id.rb_secret);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_normal:
                Notification.Builder builder = new Notification.Builder(this);
                Intent mIntet = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntet, 0);
                builder.setContentIntent(pendingIntent);
                builder.setSmallIcon(R.mipmap.notification_icon);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.notification_icon));
                builder.setAutoCancel(true);
                builder.setContentTitle("普通");
                builder.setContentText("public");
                Notification notification = builder.build();
                NotificationManager mNotifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.notify(1,notification);
                break;
            case R.id.btn_foldable:
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_fold_notification);
                Notification.Builder builder1 = new Notification.Builder(this);
                Intent mIntet1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
                PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, mIntet1, 0);
                builder1.setContentIntent(pendingIntent1);
                builder1.setSmallIcon(R.mipmap.notification_icon);
                builder1.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.notification_icon));
                builder1.setAutoCancel(true);
                builder1.setContentTitle("普通");
                builder1.setContentText("public");
                Notification notification1 = builder1.build();
                notification1.bigContentView = remoteViews;
                NotificationManager mNotifyMgr1 =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr1.notify(2,notification1);
                break;
            case R.id.btn_hangable:
                break;
        }
    }
}
