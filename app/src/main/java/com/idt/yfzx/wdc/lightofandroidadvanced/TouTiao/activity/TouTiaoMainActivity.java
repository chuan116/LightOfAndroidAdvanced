package com.idt.yfzx.wdc.lightofandroidadvanced.TouTiao.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.TouTiao.base.BaseActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.TouTiao.helper.BottomNavigationViewHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouTiaoMainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    @BindView(R.id.left_navigation)
    NavigationView leftNavigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerlayout;

    @Override
    protected void onBeforeInitial() {
        this.setContentView(R.layout.activity_tou_tiao_main);
    }

    @Override
    protected void onAfterInitial() {
        mainToolbar.inflateMenu(R.menu.menu_activity_main);
        mainToolbar.setTitle("");
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerlayout, mainToolbar, R.string.app_name,  R.string.app_name);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        leftNavigation.setNavigationItemSelectedListener(this);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "点击搜索键了", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "点击导航键了", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void goback(String event) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
