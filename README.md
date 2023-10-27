# DimensionUtil - 尺寸转换工具类

## 仓库迁移/弃用声明
**重要声明：DimensionUtil项目终止维护并迁移至AndroidWidget仓库**

为了更好地维护和提供最佳的用户体验，我们决定终止DimensionUtil项目的维护，并将其功能迁移至AndroidWidget仓库。这个决定是为了整合相关功能，确保其持续更新和支持。因此，我们强烈建议您将您的应用或项目迁移到AndroidWidget，以继续享受相关功能的正常使用。

以下是一些关键信息：

+ **DimensionUtil项目终止维护：** 从现在开始，我们将不再更新或维护DimensionUtil项目。这意味着不会有新的功能添加或错误修复。

+ **AndroidWidget仓库：** 我们已将DimensionUtil的功能迁移到AndroidWidget仓库，您可以在 [AndroidWidget GitHub仓库](https://github.com/bonepeople/AndroidWidget) 找到与DimensionUtil相同的功能以及更多其他功能。

+ **更新AndroidWidget版本：** 您可以通过以下方式将AndroidWidget集成到您的项目中（请参考当前的最新版本号）：
    ```gradle
    // https://github.com/bonepeople/AndroidWidget
    implementation("com.github.bonepeople:AndroidWidget:1.6.0")
    ```

+ **迁移建议：** 为了确保您的应用或项目能够继续正常运作，我们强烈建议您尽快迁移到AndroidWidget。您可以参考下方提供的方法映射表格进行迁移，以帮助您进行平稳的过渡。
    | DimensionUtil 方法       | AndroidWidget 方法  | 方法说明                              |
    |-------------------------|---------------------|---------------------------------------|
    | DimensionUtil.getPx     | AppDensity.getPx    | 获取像素单位（px）的尺寸              |
    | DimensionUtil.getDp     | AppDensity.getDp    | 将像素单位（px）转换为密度无关单位（dp） |
    | DimensionUtil.getSp     | AppDensity.getSp    | 将像素单位（px）转换为字体密度无关单位（sp） |
    | DimensionUtil.getStatusBarHeight     | AppSystem.getStatusBarHeight  | 获取状态栏的高度   |
    | DimensionUtil.getNavigationBarHeight | AppSystem.getNavigationBarHeight  | 获取导航栏的高度 |
    | DimensionUtil.getDisplayWidth         | AppSystem.getScreenWidth  | 获取屏幕宽度                |
    | DimensionUtil.getDisplayHeight        | AppSystem.getScreenHeight  | 获取屏幕高度                |
    | DimensionUtil.setDefaultMetrics       | AppDensity.defaultMetrics  | 设置默认的屏幕密度参数       |

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
* 支持设置不同的屏幕密度进行计算。

## 集成方法
使用Gradle构建工具集成：(新版本工具类仅支持androidx环境)
```groovy
dependencies {
    // android support 工程
    implementation 'com.bonepeople.android.lib:DimensionUtil:1.1'
    // androidx 工程
    implementation 'com.bonepeople.android.lib:DimensionUtil:1.3.2'
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
  工具类默认使用系统的屏幕密度进行计算，如果App设置了自己的屏幕密度，可以通过`setDefaultMetrics(DisplayMetrics)`方法进行设置，新设置的屏幕密度会保存在静态变量中供后续使用。
  ```
  DimensionUtil.setDefaultMetrics(getResources().getDisplayMetrics());
  ```

## 混淆说明
  本项目对混淆无任何要求。

## 效果展示
![示例APP](https://resources.mydaydream.com/img/2020/06/09/6f7357ac-5527-463c-9ff6-6924c6989c73.jpg)

## 国内文档地址
* https://www.jianshu.com/p/8c148ecb6ef1

## 维护计划
  不定期进行功能更新，欢迎提出功能需求。
