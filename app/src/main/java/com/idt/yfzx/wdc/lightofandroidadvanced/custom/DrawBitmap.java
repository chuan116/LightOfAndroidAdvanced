package com.idt.yfzx.wdc.lightofandroidadvanced.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.facebook.imageutils.BitmapUtil;
import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.GetBitMapUtil;

/**
 * Created by 王大川 on 2018-04-08.
 */

public class DrawBitmap extends View {
    private int screenW;
    private int screenH;
    //1 创建Picture
    private Picture mPicture = new Picture();

    //2 录制内容方法
    private void recording() {
        //开始录制
        Canvas canvas = mPicture.beginRecording(screenW, screenH);
        Bitmap mbitmap = GetBitMapUtil.getBitMapFromRaw(mcontext, R.raw.onepiece);
        canvas.drawBitmap(mbitmap, new Matrix(), new Paint());
        // 指定图片绘制区域(左上角的四分之一)
        Rect src = new Rect(0, 0, mbitmap.getWidth(), mbitmap.getHeight());
        // 指定图片在屏幕上显示的区域
        Rect dst = new Rect(0, 0, screenW, screenH);
        // 绘制图片
        canvas.drawBitmap(mbitmap, src, dst, null);
        mPicture.endRecording();
    }

    private Context mcontext;

    public DrawBitmap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
//        recording();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        screenW = MeasureSpec.getSize(widthMeasureSpec);      //
        screenH = MeasureSpec.getSize(heightMeasureSpec);
        recording();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPicture(mPicture);
    }

}
