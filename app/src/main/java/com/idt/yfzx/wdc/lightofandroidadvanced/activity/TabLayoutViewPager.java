package com.idt.yfzx.wdc.lightofandroidadvanced.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

public class TabLayoutViewPager extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_view_pager);
    }


    public void btn_onclick(View view) {

        switch (view.getId()) {
            case R.id.btn_txtnav:
                break;
            case R.id.btn_txtnav_scrollable:
                break;
            case R.id.btn_picnav:
                break;
            default:
                break;

        }

    }
}
