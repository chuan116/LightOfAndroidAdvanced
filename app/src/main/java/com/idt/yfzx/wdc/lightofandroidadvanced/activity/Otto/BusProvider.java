package com.idt.yfzx.wdc.lightofandroidadvanced.activity.Otto;

import com.squareup.otto.Bus;

/**
 * @author 王大川
 * @createTime 2018/5/29
 * <p>
 * description：
 */
public class BusProvider {
    private volatile static Bus bus = null;

    private BusProvider() {
    }

    public static Bus getInstance() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                bus = new Bus();
            }
        }
        return bus;
    }
}
