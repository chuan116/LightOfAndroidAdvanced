package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

public class NewsList extends AppCompatActivity {

    protected RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_news_list);
        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
    }
}
