package com.idt.yfzx.wdc.lightofandroidadvanced.model;

import android.content.Context;

import com.idt.yfzx.wdc.lightofandroidadvanced.entity.NewsItemEntity;
import com.idt.yfzx.wdc.lightofandroidadvanced.entity.Trailers;
import com.idt.yfzx.wdc.lightofandroidadvanced.model.impl.NewsModelImpl;

import java.util.List;

/**
 * Created by 王大川 on 2018-03-15.
 */

public interface NewsModel {


    public void  getTopNewsList(Context context,OnNewsLoadListener onWeatherLoadListener );


    public  interface OnNewsLoadListener{
        public void  onSuccess(Trailers result_list);
        public void onFail(Trailers result_list);
    }
}
