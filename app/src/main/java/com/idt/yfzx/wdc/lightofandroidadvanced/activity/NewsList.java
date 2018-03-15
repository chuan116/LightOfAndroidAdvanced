package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.NewsItemEntity;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.NewsModel;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.impl.NewsModelImpl;

import java.util.List;

public class NewsList extends AppCompatActivity implements NewsModel.OnNewsLoadListener {

    protected RecyclerView rv;
    protected NewsModelImpl  modelImpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_news_list);
        initView();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        modelImpl    =   new NewsModelImpl();
    }

    @Override
    public void onSuccess(List<NewsItemEntity> result_list) {
        System.out.println(result_list.toString());

    }

    @Override
    public void onFail(List<NewsItemEntity> result_list) {

    }
}
