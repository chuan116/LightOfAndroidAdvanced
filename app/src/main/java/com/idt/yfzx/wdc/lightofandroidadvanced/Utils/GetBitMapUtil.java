package com.idt.yfzx.wdc.lightofandroidadvanced.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 王大川 on 2018-04-10.
 * <p>
 * 几种获取bitmap方法的工具类
 */
public class GetBitMapUtil {
    /**
     * 从raw文件夹获取bitmap
     *
     * @param mcontext
     * @param resourceId
     * @return bitmap
     */
    public static Bitmap getBitMapFromRaw(Context mcontext, int resourceId) {
        return BitmapFactory.decodeResource(mcontext.getResources(), resourceId);
    }

    /**
     * 从assert文件夹获取bitmap
     *
     * @param mcontext
     * @param picName
     * @return
     */
    public static Bitmap getBitMapFrom(Context mcontext, String picName) {
        Bitmap bitmap = null;
        try {
            InputStream is = mcontext.getAssets().open(picName);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     * 从sd卡中 获取 bitmap
     *
     * @param path
     * @return
     */
    public static Bitmap getBitMapFromSDCard(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        return bitmap;
    }


    /**
     * 从文件流 获取bitmap
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static Bitmap getBitmapFromInputStream(InputStream is) throws IOException {
        // 此处省略了获取网络输入流的代码
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        is.close();
        return bitmap;
    }

}
