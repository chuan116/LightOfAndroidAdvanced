package com.idt.yfzx.wdc.lightofandroidadvanced.mvp.presenter;

import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.bean.EntranceBean;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.IModel;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.impl.EntranceModelmpl;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.model.impl.IModelImpl;
import com.idt.yfzx.wdc.lightofandroidadvanced.mvp.view.IView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @author 王大川
 * @createTime 2018/5/31
 * <p>
 * description：
 */
public class EntrancePresenter  implements  IPresenter{
    private IView  ivew;
    private IModel iModel ;

    public EntrancePresenter(IView ivew) {
        this.ivew = ivew;
        iModel  = new EntranceModelmpl();
        EventBus.getDefault().register(this);
    }

    @Override
    public void loadData() {
        ivew.showLoadingDialog("正在加载");
        iModel.getTopNewsList();

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void  getData(EntranceBean content){
        ivew.hideLoadingDialog();
//        System.out.println("content = [" + content.getContent() + "]");
        ivew.displayData(content.getContent());
    }
}
