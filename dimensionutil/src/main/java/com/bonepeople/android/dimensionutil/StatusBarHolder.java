package com.bonepeople.android.dimensionutil;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 状态栏占位控件
 * <p>
 * 可以把这个控件放在界面的布局中，宽高设置为wrap_content，这样会出现一个宽高都是状态栏高度的方块，
 * 其他的布局根据这个控件的位置就可以方便的空出状态栏的空间。使用这个控件也可以解决布局中无法引用状态栏高度的问题。
 */
public class StatusBarHolder extends View {

    public StatusBarHolder(Context context) {
        super(context);
    }

    public StatusBarHolder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StatusBarHolder(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(DimensionUtil.getStatusBarHeight(), DimensionUtil.getStatusBarHeight());
    }
}