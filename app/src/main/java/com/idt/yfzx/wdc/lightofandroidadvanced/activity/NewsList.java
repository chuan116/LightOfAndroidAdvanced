package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.adapter.NewsListAdapter;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.Trailers;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.IModel;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.impl.IModelImpl;

public class NewsList extends AppCompatActivity  {

    protected RecyclerView rv;
    protected IModelImpl modelImpl;
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
        modelImpl = new IModelImpl();
    }

    public void onSuccess(Trailers result_list) {
        System.out.println(result_list.toString());
        adapter = new NewsListAdapter(result_list.getTrailers(), this);
        rv.setAdapter(adapter);
    }

    public void onFail(Trailers result_list) {

    }

    public void loadData() {

    }
}
