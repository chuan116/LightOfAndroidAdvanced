package com.idt.yfzx.wdc.lightofandroidadvanced.myAnnotation;


import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.idt.yfzx.wdc.lightofandroidadvanced.R;


@ContentView(R.layout.activity_annotation)
public class AnnotationActivity extends AnnotationBaseActivity {

    public final String  TAG = this.getClass().getName();

//  @WDCBindView(viewId = R.id.txt_main_title)
  public TextView txt;

  @WDCBindView(viewId = R.id.btn_clickme)
  public Button btn;



    @Override
    public void onBeforeInitial() {

    }
    @Override
    public void onAfterInitial() {
        txt.setText("绑定后的值");

    }

    @WDCBindSingleClick(viewId = R.id.txt_main_title)
    public void title_singleCLick(){
        Toast.makeText(this,"点击了text ",Toast.LENGTH_LONG).show();
    }

    @WDCBindSingleClick(viewId=R.id.btn_clickme)
    public void  btn_singleClick(){
        Toast.makeText(this,"点击了button ",Toast.LENGTH_LONG).show();
    }
}
