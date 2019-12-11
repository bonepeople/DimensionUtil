package com.bonepeople.android.dimensionutil.simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bonepeople.android.lib.dimensionutil.DimensionUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView_display, textView_1, textView_2, textView_3;
    private EditText editText_1, editText_2, editText_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_display = findViewById(R.id.textView_display);
        textView_1 = findViewById(R.id.textView_1);
        textView_2 = findViewById(R.id.textView_2);
        textView_3 = findViewById(R.id.textView_3);
        editText_1 = findViewById(R.id.editText_1);
        editText_2 = findViewById(R.id.editText_2);
        editText_3 = findViewById(R.id.editText_3);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);

        textView_display.setText("当前手机的屏幕宽度为:" + DimensionUtil.getDisplayWidth() + "，高度为:" + DimensionUtil.getDisplayHeight());
    }

    private void dp2px() {
        try {
            float dp = Float.parseFloat(editText_1.getText().toString());
            textView_1.setText(String.valueOf(DimensionUtil.getPx(dp)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void px2dp() {
        try {
            int px = Integer.parseInt(editText_2.getText().toString());
            textView_2.setText(String.valueOf(DimensionUtil.getDp(px)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sp2px() {
        try {
            float sp = Float.parseFloat(editText_3.getText().toString());
            textView_3.setText(String.valueOf(DimensionUtil.getPx(TypedValue.COMPLEX_UNIT_SP, sp)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                dp2px();
                break;
            case R.id.button_2:
                px2dp();
                break;
            case R.id.button_3:
                sp2px();
                break;
        }
    }
}
