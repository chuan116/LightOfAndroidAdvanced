package com.idt.yfzx.wdc.lightofandroidadvanced.activity.RXJava;

import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.idt.yfzx.wdc.lightofandroidadvanced.R;
import com.idt.yfzx.wdc.lightofandroidadvanced.base.BaseActivity;
import com.idt.yfzx.wdc.lightofandroidadvanced.custom.LoadingDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RXJavaActivity extends BaseActivity {
    public static final String TAG = "GROWUP";
    @BindView(R.id.go_post)
    Button goPost;
    DialogFragment dg_fragment;
    LoadingDialog loading;
    @BindView(R.id.txt_content)
    TextView txtContent;

    @Override
    protected void onBeforeInitial() {
        setContentView(R.layout.activity_rxjava);
    }

    @Override
    protected void onAfterInitial() {


    }

    public String goPost() {
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15566885957";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
//                .add("键", "值")
//                .add("键", "值")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
//            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }


    }

    @OnClick(R.id.go_post)
    public void onViewClicked() {
        loading = new LoadingDialog(RXJavaActivity.this);
        loading.setMessage("正在加载...").show();
        Observable<String> observable = Observable.create(
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        e.onNext(goPost());
                    }
                }
        ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String value) {
                loading.dismiss();
                txtContent.setText(value);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        };
        observable.subscribe(observer);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ThreadCallBack(String a) {

    }




}
