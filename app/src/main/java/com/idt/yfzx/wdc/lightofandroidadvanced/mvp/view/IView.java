package com.idt.yfzx.wdc.lightofandroidadvanced.mvp.view;

/**
 * @author 王大川
 * @createTime 2018/5/31
 * <p>
 * description：
 */
public interface IView {

    public void  showLoadingDialog(String  messgae);
    public  void   displayData(String  text);

    public void hideLoadingDialog();
}
