package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 王大川 on 2018-04-08.
 */

public class RecoardPicture extends View {
    private int screenW;
    private int screenH;
    //1 创建Picture
    private Picture mPicture = new Picture();
    //2 录制内容方法
    private void recording(){
        //开始录制
        Canvas canvas = mPicture.beginRecording(screenW, screenH);
        //创建一个画笔
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(0, 0, screenW, screenH);
        // 绘制背景矩形
        paint.setColor(Color.GRAY);
        canvas.drawRect(rectF, paint);
        // 绘制一个圆
        paint.setColor(Color.BLUE);
        canvas.translate(screenW/2,screenH/2);
        canvas.drawCircle(0,0,500,paint);
        mPicture.endRecording();
    }
    public RecoardPicture(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        recording();
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        screenW  = MeasureSpec.getSize(widthMeasureSpec);      //
        screenH = MeasureSpec.getSize(heightMeasureSpec);
        recording();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);canvas.drawPicture(mPicture);
    }
}
