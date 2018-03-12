package com.idt.yfzx.wdc.lightofandroidadvanced.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

import java.util.List;

/**
 * Created by 王大川 on 2018-03-06.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private List<String> listdata;
    Context mcontext;


    OnItemClickListener onItemClickListener;

    public NewsListAdapter(List<String> listdata, Context mcontext) {
        this.mcontext = mcontext;
        this.listdata = listdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.home_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mian_txt.setText(listdata.get(position));
        holder.mian_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onitemSingleClick(position);

            }
        });
        holder.mian_txt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                onItemClickListener.onitemLongClick(position);

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mian_txt;
        public MyViewHolder(View itemView) {
            super(itemView);
            mian_txt = itemView.findViewById(R.id.main_txt);
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
