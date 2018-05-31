package com.idt.yfzx.wdc.lightofandroidadvanced.mvp.view;

import android.os.Bundle;
import android.widget.TextView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.activity.RXJava.RXJavaActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.custom.LoadingDialog;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.bean.EntranceBean;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.presenter.EntrancePresenter;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.presenter.IPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVP_Entrance extends BaseActivity implements IView {

    @BindView(R.id.main_txt)
    TextView mainTxt;

    LoadingDialog loading;
    IPresenter   iPresenter;
    @Override
    protected void onBeforeInitial() {
        setContentView(R.layout.activity_mvp__entrance);
        iPresenter =  new EntrancePresenter(this) ;

    }

    @Override
    protected void onAfterInitial() {
        loading = new LoadingDialog(MVP_Entrance.this);
        loading.setMessage("正在加载...");
        iPresenter.loadData();
    }

    @Override
    public void showLoadingDialog(String messgae) {
        loading.show();
    }

    @Override
    public void displayData(String  text) {
        this.mainTxt.setText(text);
    }

    @Override
    public void hideLoadingDialog() {
        loading.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void  getData( String  a  ){

    }


}
