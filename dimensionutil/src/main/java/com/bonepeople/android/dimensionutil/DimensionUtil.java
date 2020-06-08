package com.bonepeople.android.dimensionutil;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * 尺寸转换工具类
 * <p>包含通用的尺寸转换方法</p>
 *
 * @author bonepeople
 */
public class DimensionUtil {

    /**
     * 获取px单位数值
     * <p>将dp单位的数值转换为px单位的数值，如果转换单位不是dp，可以调用{@link #getPx(int, float)}进行转换</p>
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
        return (int) TypedValue.applyDimension(unit, value, Resources.getSystem().getDisplayMetrics());
    }

    /**
     * 获取dp单位数值
     * <p>将px单位的数值转换为dp单位的数值</p>
     *
     * @param px 被转换数值，单位为px
     * @return 转换后的数值，单位为dp
     */
    public static float getDp(int px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 获取sp单位数值
     * <p>将px单位的数值转换为sp单位的数值</p>
     *
     * @param px 被转换数值，单位为px
     * @return 转换后的数值，单位为sp
     */
    public static float getSp(int px) {
        return px / Resources.getSystem().getDisplayMetrics().scaledDensity;
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
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕显示区域的高度
     * <p>大部分情况下该数值与屏幕的高度一致，若不正常可以考虑使用{@link #getDisplayHeight(Activity)}方法获取</p>
     *
     * @return 屏幕高度，单位为px
     */
    public static int getDisplayHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels + getNavigationBarHeight();
    }

    /**
     * 获取屏幕显示区域的高度
     *
     * @return 屏幕高度，单位为px
     */
    public static int getDisplayHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
        return metrics.heightPixels;
    }
}
