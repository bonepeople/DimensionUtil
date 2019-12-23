### DimensionUtil &nbsp;[ ![JCenter](https://img.shields.io/badge/JCenter-1.0-blue) ](https://bintray.com/bonepeople/maven/DimensionUtil/1.0/link)
尺寸转换工具类
---

## 简介
DimensionUtil是一个用于尺寸转换的工具类，主要的用途是将`SP`转换为`PX`。

**主要功能：**
* 将DP单位的数值转换为PX单位的数值。
* 将其他TypedValue的数值转换为PX单位的数值。
* 将PX单位的数值转换为DP单位的数值。
* 获取屏幕显示区域的宽度。
* 获取屏幕显示区域的高度。

## 集成方法
使用Gradle构建工具集成：
```groovy
dependencies {
    implementation 'com.bonepeople.android.lib:DimensionUtil:1.0'
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

## 混淆说明
  本项目对混淆无任何要求。
