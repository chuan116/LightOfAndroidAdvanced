package com.idt.yfzx.wdc.lightofandroidadvanced;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.SystemUtils;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.CardViewActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.NotificationActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.VolleyActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.adapter.HomeAdapter;
import com.idt.yfzx.wdc.lightofandroidadvanced.adapter.WaterFallAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WaterFallAdapter.OnItemClickListener {
    private RecyclerView rv;
    private HomeAdapter homeAdapter;
    private WaterFallAdapter waterFallAdapter;
    private List<String> listData;
    private ConstraintLayout container;

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "当前系统最大可使用内存为:" + SystemUtils.getMaxMemory(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.container);
        rv = findViewById(R.id.common_recyclerview);
        //设置布局管理器 (线性排列 默认垂直排列)
//        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        //设置水平排列
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rv.setLayoutManager(linearLayoutManager);
        //设置item添加删除动画
        rv.setItemAnimator(new DefaultItemAnimator());
//        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
//        divider.setDrawable(this.getDrawable(R.drawable.shape_gradient));
        //添加Android自带的分割线
//        rv.addItemDecoration(divider);
        initData();
      /*  homeAdapter = new HomeAdapter(listData, this);
        homeAdapter.setOnItemClickListener(this);*/
        waterFallAdapter = new WaterFallAdapter(listData, this);
        waterFallAdapter.setOnItemClickListener(this);
        rv.setAdapter(waterFallAdapter);

    }


    private void initData() {
        listData = new ArrayList<String>();
        listData.add("TabAdapter");
//        listData.add("2");
//        listData.add("3");
        listData.add("Volley");
        listData.add("CardView");
        listData.add("Notification");
        for (int i = 0; i < 30; i++) {
            listData.add(i + "");
        }


    }

    @Override
    public void onitemSingleClick(final int postion) {
        Snackbar.make(container, "点击了第" + listData.get(postion) + "", Snackbar.LENGTH_SHORT).setAction("进入?", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "OK!", Toast.LENGTH_SHORT).show();
                if ("TabAdapter".equals(listData.get(postion))) {
                    //跳转activity
                    return;
                }
                if ("Volley".equals(listData.get(postion))) {
                    //跳转到volley activity
                    startActivity(VolleyActivity.class);
                    return;
                }

                if("CardView".equals(listData.get(postion))){
                    startActivity(CardViewActivity.class);
                    return;

                }

                if("Notification".equals(listData.get(postion))){
                    startActivity(NotificationActivity.class);
                }

            }
        }).show();
    }

    @Override
    public void onitemLongClick(final int position) {
        new AlertDialog.Builder(this).setTitle("确定删除此项么").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //确定
                listData.remove(position);
                waterFallAdapter.notifyItemRemoved(position);
//                homeAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }


    public void startActivity(Class c) {
        Intent intent = new Intent();
        intent.setClass(this, c);
        this.startActivity(intent);

    }
}
