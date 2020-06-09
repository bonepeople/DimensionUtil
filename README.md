# DimensionUtil - 尺寸转换工具类

## 简介
DimensionUtil是一个用于尺寸转换的工具类，主要的用途是将`SP`转换为`PX`。

**主要功能：**
* 将DP单位的数值转换为PX单位的数值。
* 将其他TypedValue的数值转换为PX单位的数值。
* 将PX单位的数值转换为DP单位的数值。
* 获取屏幕显示区域的宽度。
* 获取屏幕显示区域的高度。
* 获取状态栏高度，添加了一个状态栏占位控件。
* 获取导航栏高度。

## 集成方法
使用Gradle构建工具集成：
```groovy
dependencies {
    // androud support 工程
    implementation 'com.bonepeople.android.lib:DimensionUtil:1.1'
    // androidX 工程
    implementation 'com.bonepeople.android.lib:DimensionUtil:1.2.2'
}
```

## 使用示例
* 获取PX单位的数值
  ```java
  float height = 5.5f;
  int px = DimensionUtil.getPx(height);
  ```
  ```java
  float textSize = 5.5f;
  int px = DimensionUtil.getPx(android.util.TypedValue.COMPLEX_UNIT_SP, textSize);
  ```
* 获取DP单位的数值
  ```java
  int width = 44;
  float dp = DimensionUtil.getDp(width);
  ```
* 获取屏幕显示区域的宽度
  ```java
  int width = DimensionUtil.getDisplayWidth();
  ```
* 获取屏幕显示区域的高度
  ```java
  int height = DimensionUtil.getDisplayHeight();
  ```
* 获取状态栏高度/导航栏高度
  
  此处获取的是像素值，在java代码中可以直接调整控件的位置。
  ```java
  int statusBarHeight = DimensionUtil.getStatusBarHeight();
  int navigationBarHeight = DimensionUtil.getNavigationBarHeight();
  pageContainer.setPadding(0, statusBarHeight, 0, navigationBarHeight);
  ```
  针对布局中无法引用状态栏高度的情况，可以使用StatusBarHolder控件达到状态栏占位的目的。
  ```xml
  <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.bonepeople.android.lib.dimensionutil.StatusBarHolder
            android:id="@+id/statusBarHolder"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layout_constraintTop_toBottomOf="@id/statusBarHolder" />
    </androidx.constraintlayout.widget.ConstraintLayout>
  ```

## 混淆说明
  本项目对混淆无任何要求。

## 效果展示
![示例APP](https://resources.mydaydream.com/img/2020/06/09/6f7357ac-5527-463c-9ff6-6924c6989c73.jpg)

## 维护计划
  1.更新android-support版本开源库的功能，使其与androidX版本功能一致。
