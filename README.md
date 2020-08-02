# QSkin
基于[QMUI 2.0](https://github.com/Tencent/QMUI_Android)开发的切换亮色暗色模式的类库

# 功能特点
- 将QMUI中的换肤功能从QMUI类库中独立出来，形成单独的换肤类库
- 优化换肤功能，不需要用户额外定义属性，而是使用系统原有的属性，使用更符合我们平时编码习惯，
  如需要更换文本颜色，在QMUI中需要如下定义：
```xml
  app:qmui_skin_text_color="?attr/app_skin_common_title_text_color" />
 ```
  现在定义的格式如下：
   ```xml
  android:textColor="?attr/app_skin_common_title_text_color" />
   ```
   定义更清晰，更简单，有木有^_^哈哈
   
# 目前支持换肤的属性
|XML属性|备注|最低API
|:---:|:---:|:---:|
|android:background|背景 |>=19|
|android:textColor|文字颜色|>=19|
|android:src|图片资源 |>=19|
|android:backgroundTint|背景着色 |>=19|
|app:tint|资源着色 |>=21|
|android:drawableStart|左边资源，仅对TextView有效|>=19|
|android:drawableLeft|左边资源，仅对TextView有效|>=19|
|android:drawableTop|上边资源，仅对TextView有效|>=19|
|android:drawableEnd|右边资源，仅对TextView有效|>=19|
|android:drawableRight|右边资源，仅对TextView有效|>=19|
|android:drawableBottom|下边资源，仅对TextView有效|>=19|

# ToDo
* 支持style
