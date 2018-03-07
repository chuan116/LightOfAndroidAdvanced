package com.idt.yfzx.wdc.lightofandroidadvanced.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idt.yfzx.wdc.lightofandroidadvance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王大川 on 2018-03-06.
 *
 *
 */

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.MyViewHolder> {
    private List<String> listdata;
    Context mcontext;
 private   List<Integer>  list_heights;

    WaterFallAdapter.OnItemClickListener onItemClickListener;

    public WaterFallAdapter(List<String> listdata, Context mcontext) {
        this.mcontext = mcontext;
        this.listdata = listdata;
        list_heights  = new ArrayList<>();
        for (int i = 0; i <listdata.size() ; i++) {
            list_heights.add((int)(200+Math.random()*300));
        }
    }

    @Override
    public WaterFallAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WaterFallAdapter.MyViewHolder holder = new WaterFallAdapter.MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.home_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(WaterFallAdapter.MyViewHolder holder, final int position) {
        holder.mian_txt.setText(listdata.get(position));
      ViewGroup.LayoutParams  layoutParams  =  holder.mian_txt.getLayoutParams();
        layoutParams.height = list_heights.get(position);
       holder.mian_txt.setLayoutParams(layoutParams);
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

    public void setOnItemClickListener(WaterFallAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
