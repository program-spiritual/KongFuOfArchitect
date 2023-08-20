1、解决图片5px间距问题
您是否经常遇到图片底部多出5px空间的问题？别担心，有4种方法可以解决。

方案一：设置其父元素的font-size:0px

方案二：在 img 的样式中添加display:block

方案三：在 img 的样式中添加vertical-align:bottom

方案四：将父元素的样式增加为line-height:5px

2、如何让元素的高度与窗口相同
当前前端中CSS的单位为vh，元素高度样式设置为height:100vh

3、修改输入框占位符样式

```
input::-webkit-input-placeholder {
  color: #babbc1;
  font-size: 12px;
}
```

4. 使用 :not 选择器
除了最后一个元素之外的所有元素都需要一些样式，这可以使用 not 选择器轻松实现。例如，要实现列表，最后一个元素不需要加下划线，如下所示：

```
li:not(:last-child) {
  border-bottom: 1px solid #ebedf0;
}
```
5、修改输入框placeholder的样式
这段CSS代码的作用是为一个输入框设置了边框、圆角、尺寸和光标颜色等样式，同时定义了输入框的占位文本样式。输入框内的文本将显示为浅黄色，占位文本将显示为深灰色。

```
.caret-color {
  width: 300px;
  padding: 10px;
  margin-top: 20px;
  border-radius: 10px;
  border: solid 1px #ffd476;
  box-sizing: border-box;
  background-color: transparent;
  outline: none;
  color: #ffd476;
  font-size: 14px;
  caret-color: #ffd476;
}

.caret-color::-webkit-input-placeholder {
  color: #4f4c5f;
  font-size: 14px;
}

```

6.使用flex布局智能地将元素固定到底部
当内容不足时，按钮应位于页面底部。当内容足够多时，按钮应该跟随内容。当你遇到类似的问题时，可以使用flex来实现智能布局！

```
<div class="container">
  <div class="main">main</div>
  <div class="footer">button</div>
</div>
```
CSS代码如下：

```
.container {
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.main {
  flex: 1;
  background-image: linear-gradient(
    45deg,
    #ff9a9e 0%,
    #fad0c4 99%,
    #fad0c4 100%
  );
  display: flex;
  align-items: center;
  justify-content: center;
  color: #fff;
}

.footer {
  padding: 15px 0;
  text-align: center;
  color: #ff9a9e;
  font-size: 14px;
}
7、去掉type=”number”末尾的箭头
默认情况下，type="number"的输入类型末尾会出现一个小箭头，但有时需要将其去掉，可以使用以下样式：

input {
  width: 300px;
  padding: 10px;
  margin-top: 20px;
  border-radius: 10px;
  border: solid 1px #ffd476;
  box-sizing: border-box;
  background-color: transparent;
  outline: none;
  color: #ffd476;
  font-size: 14px;
  caret-color: #ffd476;
  display: block;
}

input::-webkit-input-placeholder {
  color: #4f4c5f;
  font-size: 14px;
}
/* 关键样式 */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

```
8、使用outline:none去掉输入状态行
当输入框被选中时，默认会有一条蓝色状态线，可以使用outline:none将其删除。

9、解决iOS滚动条卡住的问题
在苹果手机上，滚动时元素经常会卡住。此时只有一行CSS会支持弹性滚动。
```
body,html{
  -webkit-overflow-scrolling: touch;
}
```
10、自定义选定的文本样式
您可以通过styles自定义选择文本的颜色和样式。关键样式如下：

```
::selection {
  color: #ffffff;
  background-color: #ff4c9f;
}
```
11、文本不允许被选择
使用以下样式进行实现：

```
user-select: none;

```
12、使用filter:grayscale(1)使页面处于灰度模式
一行代码会将页面置于灰色模式。

```
body{
  filter: grayscale(1);
}
```
结束