package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

import java.util.List;

/**
 * Created by 王大川 on 2018-03-29.
 */

public class PieView extends View {
    int width;
    int height;
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 矩形
        RectF rectF = new RectF(0, 0, width, height);
        // 绘制背景矩形
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(width/2,height/2,400,mPaint);
        RectF rectF2 = new RectF((width-800)/2, (height-800)/2, (width-800)/2+800, ((height-800)/2)+800 );
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rectF2, mPaint);
        //开始画饼图弧形
        for (int i = 0; i < mColors.length; i++) {
            // 绘制圆弧
            mPaint.setColor(mColors[i]);
            canvas.drawArc(rectF2,i*(360/mColors.length),(360/mColors.length),true,mPaint);
//            canvas.save();
        }
    }


    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(getResources().getColor(R.color.black));       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }


}
