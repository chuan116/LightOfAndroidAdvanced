package com.idt.yfzx.wdc.lightofandroidadvanced.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 王大川
 * <p>
 * description：
 */

@Retention(RUNTIME)
@Target({ElementType.FIELD})
public @interface WDCBindView {
    int viewId() default 0;
}
