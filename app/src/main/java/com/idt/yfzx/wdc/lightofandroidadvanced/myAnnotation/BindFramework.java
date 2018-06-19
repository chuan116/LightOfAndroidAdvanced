package com.idt.yfzx.wdc.lightofandroidadvanced.myAnnotation;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王大川
 * <p>
 * description：
 */
public class BindFramework {
    static Object o;

    public static void bind(Object obj) {
        o = obj;
        if (o instanceof Context) {
            setContentViewByAnno();
            bindViews();
        } else {
            throw new RuntimeException(o.getClass().getName() + "不是context的子类");
        }

    }

    /**
     * 通过注解反射 设置 contentview
     */
    public static void setContentViewByAnno() {
        Class c = o.getClass();
        if (o instanceof Activity) {
            //注解解析
            ContentView annotation = (ContentView) c.getAnnotation(ContentView.class);
            if (annotation != null) {
                try {
                    ((Activity) o).setContentView(annotation.value());
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException(o.getClass().getName() + "不是Activity的子类");
        }

    }


    /**
     * 通过注解 生成 findViewById + onClickListener
     **/
    public static void bindViews() {
        Field[] fields = o.getClass().getDeclaredFields();
        if (!(o instanceof Activity)) {
            throw new RuntimeException(o.getClass().getName() + "不是Activity的子类");
        }

        //1.获取 所有带  singleclick注解的方法 ,将符合条件的缓存到map中。
        Method[] methods = o.getClass().getDeclaredMethods();
        final Map<Integer, Method> map_method = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            WDCBindSingleClick click = method.getAnnotation(WDCBindSingleClick.class);
            if (click != null) {
                int viewId = click.viewId();
                if (viewId > 0) {
                    map_method.put(viewId, method);
                } else {
                    throw new RuntimeException(o.getClass().getName() + " " + method.getName() + " id配置有误");
                }
            }
        }
        //2.绑定  view 并添加 onclickListener
        if (fields != null && fields.length > 0) {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                WDCBindView bindView = field.getAnnotation(WDCBindView.class);
                if (bindView != null) {
                    final int viewId = bindView.viewId();
                    if (viewId == 0) {
                        throw new RuntimeException(o.getClass().getName() + " " + field.getName() + " id配置有误");
                    }
                    field.setAccessible(true);
                    try {
                        final View view = ((Activity) o).findViewById(viewId);
                        if (map_method.containsKey(viewId)) {
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        map_method.get(viewId).invoke(o);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        field.set(o, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
