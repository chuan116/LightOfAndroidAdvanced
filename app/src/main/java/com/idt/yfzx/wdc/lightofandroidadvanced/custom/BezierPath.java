package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;

/**
 * Created by 王大川 on 2018-03-29.
 */

public class BezierPath extends View {
    int width;
    int height;
    PointF p_start, p_end, p_control;
    // 1.创建一个画笔
    private Paint mPaint = new Paint();
    Context mcontext;
    private int centerX, centerY;
    public BezierPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        initPaint();

    }

    private void initPoint() {
        centerX  = width/2;
        centerY   = height/2;
        p_start = new PointF();
        p_start.set(centerX-300, centerY);
        p_end = new PointF();
        p_end.set(centerX+300, centerY);
        p_control = new PointF();
        p_control.set(centerX, centerY+200);
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
        initPoint();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        p_control.x = event.getX();
        p_control.y = event.getY();
        this.invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint_gray = new Paint();
        paint_gray.setColor(mcontext.getResources().getColor(R.color.grey));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        canvas.drawPoint(p_start.x, p_start.y, mPaint);
        canvas.drawPoint(p_end.x, p_end.y, mPaint);
        canvas.drawPoint(p_control.x, p_control.y, mPaint);
        canvas.drawLine(p_start.x, p_start.y, p_control.x, p_control.y, paint_gray);
        canvas.drawLine(p_end.x, p_end.y, p_control.x, p_control.y, paint_gray);

        Path path = new Path();
        path.moveTo(p_start.x, p_start.y);
        path.quadTo(p_control.x, p_control.y, p_end.x, p_end.y);
        path.close();
        canvas.drawPath(path, mPaint);
    }

    // 2.初始化画笔
    private void initPaint() {
        // 创建画笔
        mPaint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        mPaint.setStyle(Paint.Style.FILL);    // 填充模式 - 描边
        mPaint.setStrokeWidth(15);              // 边框宽度 - 10


    }
}
