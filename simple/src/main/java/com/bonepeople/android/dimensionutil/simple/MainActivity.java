package com.bonepeople.android.dimensionutil.simple;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bonepeople.android.dimensionutil.DimensionUtil;
import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends AppCompatActivity {
    private EditText editText_px_1, editText_dp, editText_px_2, editText_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImmersionBar.with(this).init();

        TextView textView_display = findViewById(R.id.textView_display);
        editText_px_1 = findViewById(R.id.editText_px_1);
        editText_dp = findViewById(R.id.editText_dp);
        editText_px_2 = findViewById(R.id.editText_px_2);
        editText_sp = findViewById(R.id.editText_sp);

        StringBuilder builder = new StringBuilder();
        builder.append("屏幕宽度:\t\t\t");
        builder.append(DimensionUtil.getDisplayWidth());
        builder.append(" px");
        builder.append("\n屏幕高度:\t\t\t");
        builder.append(DimensionUtil.getDisplayHeight());
        builder.append(" px");
        builder.append("\n状态栏高度:\t\t");
        builder.append(DimensionUtil.getStatusBarHeight());
        builder.append(" px");
        textView_display.setText(builder);

        editText_px_1.addTextChangedListener((SimpleTextWatcher) s -> px2dp());
        editText_dp.addTextChangedListener((SimpleTextWatcher) s -> dp2px());
        editText_px_2.addTextChangedListener((SimpleTextWatcher) s -> px2sp());
        editText_sp.addTextChangedListener((SimpleTextWatcher) s -> sp2px());
    }

    private void px2dp() {
        if (!editText_px_1.hasFocus())
            return;
        try {
            int px = Integer.parseInt(editText_px_1.getText().toString());
            editText_dp.setText(String.valueOf(DimensionUtil.getDp(px)));
        } catch (Exception e) {
            e.printStackTrace();
            editText_dp.setText("");
        }
    }

    private void dp2px() {
        if (!editText_dp.hasFocus())
            return;
        try {
            float dp = Float.parseFloat(editText_dp.getText().toString());
            editText_px_1.setText(String.valueOf(DimensionUtil.getPx(dp)));
        } catch (Exception e) {
            e.printStackTrace();
            editText_px_1.setText("");
        }
    }

    private void px2sp() {
        if (!editText_px_2.hasFocus())
            return;
        try {
            int px = Integer.parseInt(editText_px_2.getText().toString());
            editText_sp.setText(String.valueOf(DimensionUtil.getSp(px)));
        } catch (Exception e) {
            e.printStackTrace();
            editText_sp.setText("");
        }
    }

    private void sp2px() {
        if (!editText_sp.hasFocus())
            return;
        try {
            float sp = Float.parseFloat(editText_sp.getText().toString());
            editText_px_2.setText(String.valueOf(DimensionUtil.getPx(TypedValue.COMPLEX_UNIT_SP, sp)));
        } catch (Exception e) {
            e.printStackTrace();
            editText_px_2.setText("");
        }
    }
}
