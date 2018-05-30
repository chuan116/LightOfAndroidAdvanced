package com.idt.yfzx.wdc.lightofandroidadvanced.activity.EventBus;

/**
 * @author 王大川
 * @createTime 2018/5/29
 * <p>
 * description：
 */
public class MessageEvent {
    private String message;
    public  MessageEvent(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
