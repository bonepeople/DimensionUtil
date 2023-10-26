package com.bonepeople.android.dimensionutil;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 尺寸转换工具类
 * <p>包含通用的尺寸转换方法</p>
 * <p>默认使用系统的屏幕密度进行计算，如果需要使用App内部的屏幕密度进行计算，请使用{@link #setDefaultMetrics(DisplayMetrics)}方法进行设置。
 * 默认情况下App内部的屏幕密度与系统的屏幕密度一致。</p>
 * @deprecated 此工具类的功能已迁移至AppDensity及AppSystem，请引入com.github.bonepeople:AndroidWidget:1.6.0后使用
 * @author bonepeople
 */
@Deprecated
public class DimensionUtil {
    private static DisplayMetrics defaultMetrics = Resources.getSystem().getDisplayMetrics();

    /**
     * 获取px单位数值
     * <p>将dp单位的数值转换为px单位的数值，如果转换单位不是dp，可以使用{@link #getPx(int, float)}方法进行转换</p>
     *
     * @param dp 被转换数值，单位为dp
     * @return 转换后的数值，单位为px
     */
    public static int getPx(float dp) {
        return getPx(TypedValue.COMPLEX_UNIT_DIP, dp);
    }

    /**
     * 获取px单位数值
     * <p>将指定单位的数值转换为px单位的数值</p>
     *
     * @param unit  转换单位，参照{@link android.util.TypedValue}的单位定义
     * @param value 被转换数值
     * @return 转换后的数值，单位为px
     */
    public static int getPx(int unit, float value) {
        return (int) TypedValue.applyDimension(unit, value, defaultMetrics);
    }

    /**
     * 获取dp单位数值
     * <p>将px单位的数值转换为dp单位的数值</p>
     *
     * @param px 被转换数值，单位为px
     * @return 转换后的数值，单位为dp
     */
    public static float getDp(int px) {
        return px / defaultMetrics.density;
    }

    /**
     * 获取sp单位数值
     * <p>将px单位的数值转换为sp单位的数值</p>
     *
     * @param px 被转换数值，单位为px
     * @return 转换后的数值，单位为sp
     */
    public static float getSp(int px) {
        return px / defaultMetrics.scaledDensity;
    }

    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度，单位为px
     */
    public static int getStatusBarHeight() {
        int height = 0;
        try {
            int resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
            height = Resources.getSystem().getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return height;
    }

    /**
     * 获取导航栏高度
     * <p>安卓虚拟导航栏的高度，在全面屏的状态下依旧是原有高度</p>
     *
     * @return 状态栏高度，单位为px
     */
    public static int getNavigationBarHeight() {
        int height = 0;
        try {
            int resourceId = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            height = Resources.getSystem().getDimensionPixelSize(resourceId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return height;
    }

    /**
     * 获取屏幕显示区域的宽度
     *
     * @return 屏幕宽度，单位为px
     */
    public static int getDisplayWidth() {
        return defaultMetrics.widthPixels;
    }

    /**
     * 获取屏幕显示区域的高度
     * <p>大部分情况下该数值与屏幕的高度一致，若不正常可以考虑使用{@link #getDisplayHeight(Activity)}方法获取</p>
     *
     * @return 屏幕高度，单位为px
     */
    public static int getDisplayHeight() {
        return defaultMetrics.heightPixels + getNavigationBarHeight();
    }

    /**
     * 获取屏幕显示区域的高度
     *
     * @param activity 需要获取屏幕高度的activity
     * @return 屏幕高度，单位为px
     */
    public static int getDisplayHeight(@NonNull Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        return metrics.heightPixels;
    }

    /**
     * 设置新的屏幕密度
     * <p>新的参数将替换默认的系统密度，推荐使用Activity.getResources().getDisplayMetrics()，这样可以和当前Activity的主题一致。</p>
     *
     * @param displayMetrics App环境下的屏幕密度，传入空值将恢复为系统屏幕密度。
     */
    public static void setDefaultMetrics(@Nullable DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            defaultMetrics = Resources.getSystem().getDisplayMetrics();
        } else {
            defaultMetrics = displayMetrics;
        }
    }
}
