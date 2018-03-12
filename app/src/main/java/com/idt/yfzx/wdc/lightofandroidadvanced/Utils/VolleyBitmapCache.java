package com.idt.yfzx.wdc.lightofandroidadvanced.Utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by 王大川 on 2018-03-12.
 * <p>
 * <p>
 * 使用volley Imageloader 需实现其缓存 bitmap cache
 */
public class VolleyBitmapCache implements ImageLoader.ImageCache {
    private LruCache<String, Bitmap> mCache;

    public VolleyBitmapCache() {
        int maxSize = 10 * 1024 * 1024;// 10m
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
