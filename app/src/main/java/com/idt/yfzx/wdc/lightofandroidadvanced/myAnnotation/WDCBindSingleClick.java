package com.idt.yfzx.wdc.lightofandroidadvanced.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 王大川
 * <p>
 * description：
 */

@Target(ElementType.METHOD)
@Retention(RUNTIME)
public @interface WDCBindSingleClick {
    int viewId() default 0;

}
