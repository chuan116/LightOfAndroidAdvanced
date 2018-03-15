package com.idt.yfzx.wdc.lightofandroidadvanced.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.NewsItemEntity;

import java.util.List;

/**
 * Created by 王大川 on 2018-03-06.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private List<NewsItemEntity> listdata;
    Context mcontext;


    OnItemClickListener onItemClickListener;

    public NewsListAdapter(List<NewsItemEntity> listdata, Context mcontext) {
        this.mcontext = mcontext;
        this.listdata = listdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.news_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title;
        NetworkImageView net_iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.txt_title);
            net_iv = itemView.findViewById(R.id.net_iv);
        }
    }

    public interface OnItemClickListener {

        public void onitemSingleClick(int position);

        public void onitemLongClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
