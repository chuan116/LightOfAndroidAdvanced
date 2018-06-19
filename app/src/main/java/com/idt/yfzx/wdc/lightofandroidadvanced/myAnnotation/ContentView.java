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
@Target({ElementType.TYPE})
public @interface ContentView {
    int value() default 0;
}
//第一行:@Retention(RetentionPolicy.RUNTIME)
//
//@Retention用来修饰这是一个什么类型的注解。这里表示该注解是一个运行时注解。这样APT就知道啥时候处理这个注解了。
//
// 第二行：@Target({ElementType.TYPE})
//
//@Target用来表示这个注解可以使用在哪些地方。比如：类、方法、属性、接口等等。这里ElementType.TYPE 表示这个注解可以用来修饰：Class, interface or enum declaration。当你用ContentView修饰一个方法时，编译器会提示错误。
//
// 第三行：public @interface ContentView
//
//这里的interface并不是说ContentView是一个接口。就像申明类用关键字class。申明枚举用enum。申明注解用的就是@interface。（值得注意的是：在ElementType的分类中，class、interface、Annotation、enum同属一类为Type，并且从官方注解来看，似乎interface是包含@interface的）
//
//  /** Class, interface (including annotation type), or enum declaration */
//   TYPE,
// 第四行：int value();
//
// 返回值表示这个注解里可以存放什么类型值。比如我们是这样使用的
//
//@ContentView(R.layout.activity_home)
//R.layout.activity_home实质是一个int型id，如果这样用就会报错：
//
//@ContentView(“string”)
