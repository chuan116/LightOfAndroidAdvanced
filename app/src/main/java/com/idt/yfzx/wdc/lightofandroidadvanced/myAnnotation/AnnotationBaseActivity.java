package com.idt.yfzx.wdc.lightofandroidadvanced.myAnnotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.idt.yfzx.wdc.lightofandroidadvanced.Utils.VerifyPermission;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public abstract class AnnotationBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeInitial();
        BindFramework.bind(this);
        onAfterInitial();

        VerifyPermission.verifyStoragePermissions(this);
    }

    public abstract void onAfterInitial();

    public abstract void onBeforeInitial();

//    /**
//     * 通过注解反射 设置 contentview
//     */
//    private void setContentViewByAnno() {
//        //注解解析
//        Class c = this.getClass();
//        ContentView annotation = (ContentView) c.getAnnotation(ContentView.class);
//        if (annotation != null) {
//            try {
//                this.setContentView(annotation.value());
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    /**
     * 通过注解 生成 findViewById + onClickListener
     **/
    private void bingViews() {
        Field[] fields = this.getClass().getDeclaredFields();

        //1.获取 所有带  singleclick注解的方法 ,将符合条件的缓存到map中。
        Method[] methods = this.getClass().getDeclaredMethods();
        final Map<Integer, Method> map_method = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            WDCBindSingleClick click = method.getAnnotation(WDCBindSingleClick.class);
            if (click != null) {
                int viewId = click.viewId();
                if (viewId > 0) {
                    map_method.put(viewId, method);
                }else{
                    throw new RuntimeException(this.getClass().getName()+" "+method.getName()+" id配置有误");
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
                    if(viewId==0){
                        throw new RuntimeException(this.getClass().getName()+" "+field.getName()+" id配置有误");
                    }
                    field.setAccessible(true);
                    try {
                        final View view = this.findViewById(viewId);
                        if (map_method.containsKey(viewId)) {
                            view.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    try {
                                        map_method.get(viewId).invoke(AnnotationBaseActivity.this);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        field.set(this, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }




}
