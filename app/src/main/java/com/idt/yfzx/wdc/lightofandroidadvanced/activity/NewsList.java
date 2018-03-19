package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.adapter.NewsListAdapter;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.NewsItemEntity;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.Trailers;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.NewsModel;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.impl.NewsModelImpl;

import java.util.List;

public class NewsList extends AppCompatActivity implements NewsModel.OnNewsLoadListener {

    protected RecyclerView rv;
    protected NewsModelImpl modelImpl;
    protected NewsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_news_list);
        initView();
        loadData();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        modelImpl = new NewsModelImpl();
    }

    @Override
    public void onSuccess(Trailers result_list) {
        System.out.println(result_list.toString());
        adapter = new NewsListAdapter(result_list.getTrailers(), this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onFail(Trailers result_list) {

    }

    public void loadData() {
        modelImpl.getTopNewsList(this, this);

    }
}
