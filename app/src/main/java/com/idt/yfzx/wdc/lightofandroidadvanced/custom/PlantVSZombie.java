package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.GetBitMapUtil;

import java.util.logging.Handler;

/**
 * Created by 王大川 on 2018-04-08.
 */

public class PlantVSZombie extends View {
    private int screenW;
    private int screenH;
    //1 创建Picture
    private Picture mPicture = new Picture();
    private Context mcontext;
    private int  currentPage  = 1 ;
    private boolean  isFirstIn  = true;


    public PlantVSZombie(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        screenW = MeasureSpec.getSize(widthMeasureSpec);
        screenH = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap mbitmap = GetBitMapUtil.getBitMapFromRaw(mcontext, R.raw.plantvszombie);
        // 指定图片绘制区域(左上角的四分之一)
        int  fromwidth   =  mbitmap.getWidth()*((currentPage>11?(currentPage-11):currentPage)-1)/11;
        int  fromheight  =  currentPage>11?mbitmap.getHeight()/2:0;
        int  towidth   =  mbitmap.getWidth()*(currentPage>11?(currentPage-11):currentPage)/11;
        int  toheight  =   currentPage>11?mbitmap.getHeight():mbitmap.getHeight()/2;
        Rect src = new Rect(fromwidth, fromheight, towidth,toheight );
        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0, 0,  mbitmap.getWidth()/11, screenH);
        // 绘制图片
        canvas.translate(screenW/2,0);
        canvas.drawBitmap(mbitmap, src, dst, null);
        if(isFirstIn){
            muiHandler.sendEmptyMessageDelayed(0, 100);
        }

    }

    android.os.Handler muiHandler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isFirstIn =false;
            invalidate();
            if(currentPage>=22){
                currentPage  =1  ;
            }else{
                currentPage++;
            }
            this.sendEmptyMessageDelayed(0, 100);
        }
    };

}
