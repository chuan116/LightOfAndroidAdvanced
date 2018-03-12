package com.idt.yfzx.wdc.lightofandroidadvanced.Utils;

import android.util.Log;

/**
 * Created by 王大川 on 2018-03-09.
 */

public class   SystemUtils {
    public static int getMaxMemory(){
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");
        return maxMemory;
    }
}
