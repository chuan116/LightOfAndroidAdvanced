package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

/**
 * Created by 王大川 on 2018-03-29.
 */

public class DrawPath extends View {
    int width;
    int height;

    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    public DrawPath(Context context, @Nullable AttributeSet attrs) {
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
        Path path = new Path();   // 创建Path
        path.lineTo(200, 200); // lineTo
        path.lineTo(200, 0);
        path.close();
        //move to
        path.moveTo(200, 0);
        path.lineTo(400, 200);
        path.moveTo(400, 100);
        path.lineTo(400, 0);
        path.lineTo(600, 200);
        path.setLastPoint(600, 100);
        path.lineTo(600, 0);
        canvas.drawPath(path, mPaint);
        canvas.translate(0, 220);
        Path seperator = new Path();
        seperator.lineTo(width, 0);
        canvas.drawPath(seperator, mPaint);
        //不规则矩形 顺时针偏转
        canvas.translate(width / 4, 240);
        Path path_react = new Path();
        path_react.addRect(-100, -100, 100, 100, Path.Direction.CW);
        path_react.setLastPoint(-120, 120);                // <-- 重置最后一个点的位置

        Path path_react_ccw = new Path();
        path_react_ccw.addRect(-100, -100, 100, 100, Path.Direction.CCW);
        path_react_ccw.setLastPoint(-120, 120);                // <-- 重置最后一个点的位置
        path_react.addPath(path_react_ccw, width / 2, 0);
        canvas.drawPath(path_react, mPaint);

        canvas.translate(-1 * width / 4, 150);
        canvas.drawPath(seperator, mPaint);
        canvas.translate(0, 20);

        canvas.translate(width / 4, 0);  // 移动坐标系到屏幕3/4
        Path path_arc = new Path();
        path_arc.addArc(new RectF(0, 0, 300, 300), 0, 270);
        canvas.drawPath(path_arc, mPaint);


    }


    // 2.初始化画笔
    private void initPaint() {
        // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        mPaint.setStrokeWidth(10);              // 边框宽度 - 10
    }


}
