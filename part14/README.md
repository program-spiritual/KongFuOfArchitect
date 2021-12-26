## 第十四部分 案例

实现目标

桌面客户端 简单工具箱

### pyqt5 篇

#### 基础布局

- [hello](./simple-tool-box/src/hello.py)
- [hello-oop](./simple-tool-box/src/hello.py)
- [水平布局](./simple-tool-box/src/h_layout.py)
- [垂直布局](./simple-tool-box/src/v_layout.py)
- [宫格布局](./simple-tool-box/src/g_layout.py)
- [表单布局](./simple-tool-box/src/f_layout.py)

#### 弹框

- [基本弹框](simple-tool-box/src/dialog.py)

#### 创建主弹框

- [一个主窗口](simple-tool-box/src/main_window.py)

> 注意：当您以自己的方法实现不同的 GUI 组件时，您正在使代码更具可读性和可维护性。但是，这不是一个要求，因此您可以自由地以您最喜欢的方式组织代码。
> 

到目前为止，您已经领略了 PyQt5 系列小部件中一些更重要的图形组件。在接下来的两个部分中，您将领略与 PyQt GUI 应用程序相关的其他重要概念。


#### Applications


在 `PyQt` 中，任何 `QT` 例都被视为 `application`。每个 `PyQt GUI` 应用程序必须有一个 `QApplication` 对象。申请的一些职责包括：

- 初始化
- 事件轮询和事件处理
- 系统维度和应用维度的设置
- 系统全局信息，例如应用目录、窗口尺寸、等等
- 转换一般的命令行参数
- 定义应用的外观
- 提供本地化能力

##### 事件轮询

GUI 应用程序由事件驱动。这意味着，功能和方法是响应用户操作执行的，如单击按钮、从组合框中选择项目、在文本编辑中输入或更新文本、按键盘上的键等。这些用户操作通常称为事件。

事件通常由事件循环（也称为主循环）处理。事件循环是一个无限循环，其中处理和发送来自用户、窗口系统和任何其他源的所有事件。事件循环等待事件发生，然后调度它执行某些任务。事件循环继续工作，直到应用程序终止。

所有 GUI 应用程序都使用事件循环。事件循环是一种等待事件发生的无限循环。如果发生事件，则循环检查事件是否是终止事件。在这种情况下，循环被终止，应用程序退出。否则，事件将发送到应用程序的事件队列以进行进一步处理，循环将重新开始。

> PyQt 最初开发为针对 Python 2 的目标， 它已经有一个`exec`关键字。在早期版本中，在`.exec_`末尾添加了一个下划线，以帮助避免名称冲突。`Pyqt5` 的目标是 `Python 3`， 它没有`exec`关键字。尽管如此，库还是提供了启动事件循环的两种方法：
> 

1. exec_()
2. exec()

要触发响应操作，则需要将事件与要执行的操作连接起来。在 `PyQt5` 中，您可以使用信号和插槽机制建立该连接。您将在下一节中涵盖这些内容。

#### 信号和插槽

PyQt 小部件充当活动捕捉者。这意味着每个小部件都能捕捉到特定数量的事件，如鼠标点击、按键等。为了响应这些事件，小部件总是发出信号，这是一种宣布其状态变化的信息。信号本身不执行任何操作。

如果您想要触发操作的信号，则需要将其连接到插槽。这是每当发出连接信号时执行操作的功能或方法。您可以使用任何 Python `callable` （或`回调`） 作为插槽。

如果信号连接到插槽，则每当发出信号时，都会调用插槽。如果信号未连接到任何插槽，则不会发生任何事件，并且会忽略信号。以下是此机制的一些最有用的功能：

- 一个信号可以连接到一个或多个插槽。
- 一个信号也可能连接到另一个信号。
- 一个插槽可能连接到一个或多个信号。

您可以使用以下语法将信号连接到插槽：

```python
widget.signal.connect(slot_function)
```

这将slot_function连接到小部件的信号。每当发出信号时，都会调用`slot_function()`。此代码向您展示如何使用信号和插槽机制：

[插槽与信号](src/signals_slots.py)

注意：每个小部件都有自己的一组预定义信号。您可以在小部件的文档页面上查看它们。

如果您的插槽功能需要接收额外的参数，则您可以使用 `functools.partial`传递它们。例如，您可以修改问候如下：

```python
def greeting(who):
    """Slot function."""
    if msg.text():
        msg.setText('')
    else:
        msg.setText(f'Hello {who}')
```

此时，你可以自定义参数

```python
btn.clicked.connect(functools.partial(greeting, 'World!'))
```

要使此代码工作，您需要首先导入 `functools`。调用 `functools.partial()`返回一个对象， 其行为类似于与`greeting() with who='World!'.`，当用户单击按钮时，"Hello World！" 消息将像以前一样显示在标签中。


现在，您已经完成了对 PyQt5 最重要的概念的理解。有了这些知识和库的文档，您就可以开始开发自己的 `GUI` 应用程序。~~在下一节中~~，您将构建您的第一个功能齐全的 `GUI` 应用程序。

### 使用 `Python` 和 `Pyqt` 创建计算器

我们将使用 MVC 模式来实现这个计算器，简单描述一下 MVC 模式：

- 模型
  - 关心您的应用程序的业务逻辑。它包含核心功能和数据。对于您的计算器，该模型将处理计算。
- 视图
  - 它承载最终用户与应用程序交互所需的所有小部件。该视图还会接收用户操作和事件。对于您的计算器，视图将是您将在屏幕上看到的窗口。
- 控制器
  - 控制器将模型和视图连接起来，使应用程序工作。用户事件（或请求）发送到控制器，使模型工作。当模型以正确的格式提供请求的结果（或数据）时，控制器将其转发到视图。对于您的计算器，控制器将从 GUI 接收用户事件，要求模型执行计算，并随结果更新 GUI。

计算器实现步骤

- 用户在视图 （ `GUI` ）上执行操作或请求 （事件）。
- 视图通知控制器有关用户的操作。
- 控制器会收到用户的请求，并查询模型以获得响应。
- 模型处理控制器查询，执行所需的操作，并返回答案或结果。
- 控制器接收模型的答案并相应地更新视图。
- 用户最终在视图上看到请求的结果。

#### 创建骨架

您将首先为您的应用程序实现一个基本骨架，称为 `pycalc.py`

[pycalc](./simple-tool-box/src/pycalc.py)

#### 完成视图层

让我们通过添加数字的显示屏和按钮来完成 GUI。您还将添加基本数学操作和清除显示屏的按钮。

````python
from PyQt5.QtCore import Qt
from PyQt5.QtWidgets import QGridLayout
from PyQt5.QtWidgets import QLineEdit
from PyQt5.QtWidgets import QPushButton
from PyQt5.QtWidgets import QVBoxLayout
````
您将使用 `QVBox` 布局进行计算器的总体布局。您还将使用 `QGridLayout` 对象来排列按钮。最后，您导入显示屏的 `QLineEdit` 和按钮的 `QPush` 按钮。现在，文件顶部应有八个导入语句。

您将使用 `QVBox` 布局将显示屏放在顶部，按钮放在底部的网格布局中。

实现未实现方法

```python
class PyCalcUi(QMainWindow):
    # Snip
    def _createDisplay(self):
        """Create the display."""
        # Create the display widget
        self.display = QLineEdit()
        # Set some display's properties
        self.display.setFixedHeight(35)
        self.display.setAlignment(Qt.AlignRight)
        self.display.setReadOnly(True)
        # Add the display to the general layout
        self.generalLayout.addWidget(self.display)
```

接下来，您将实现`._createButtons()` 为计算器创建按钮。
您将使用字典将每个按钮的文本和位置保留在网格上。
您还将使用 `QGridLayout` 来安排计算器窗口上的按钮。最终代码将看起来像这样：

```python
class PyCalcUi(QMainWindow):
    # Snip
    def _createButtons(self):
        """Create the buttons."""
        self.buttons = {}
        buttonsLayout = QGridLayout()
        # Button text | position on the QGridLayout
        buttons = {'7': (0, 0),
                   '8': (0, 1),
                   '9': (0, 2),
                   '/': (0, 3),
                   'C': (0, 4),
                   '4': (1, 0),
                   '5': (1, 1),
                   '6': (1, 2),
                   '*': (1, 3),
                   '(': (1, 4),
                   '1': (2, 0),
                   '2': (2, 1),
                   '3': (2, 2),
                   '-': (2, 3),
                   ')': (2, 4),
                   '0': (3, 0),
                   '00': (3, 1),
                   '.': (3, 2),
                   '+': (3, 3),
                   '=': (3, 4),
                  }
        # Create the buttons and add them to the grid layout
        for btnText, pos in buttons.items():
            self.buttons[btnText] = QPushButton(btnText)
            self.buttons[btnText].setFixedSize(40, 40)
            buttonsLayout.addWidget(self.buttons[btnText], pos[0], pos[1])
        # Add buttonsLayout to the general layout
        self.generalLayout.addLayout(buttonsLayout)
```
现在，计算器的 `GUI`（或视图）可以显示显示器和按钮。
但是仍然无法更新显示屏上显示的信息。
您可以通过添加一些额外的方法来解决这个问题：

- setDisplayText()
  - 设置和更新显示器的文本
- displayText()
  - 获取当前显示器的文本
- clearDisplay() 
  - 清除显示器的文本

这些方法将形成 `GUI` 公共界面，并完成您的 `Python` 计算器的视图类。下面是一个可能的实现：

```python
class PyCalcUi(QMainWindow):
    # Snip
    def setDisplayText(self, text):
        """Set display's text."""
        self.display.setText(text)
        self.display.setFocus()

    def displayText(self):
        """Get display's text."""
        return self.display.text()

    def clearDisplay(self):
        """Clear the display."""
        self.setDisplayText('')
```

您已经完成了计算器的 `GUI` 接口。
但是，如果您尝试进行一些计算，那么您就会注意到计算器尚未做任何事情。
那是因为你没有实现模型或控制器。
接下来，您将添加一个基本的控制器类，开始为您的计算器提供生命。

#### 创建基本控制器

在此部分中，您将编写计算器控制器类的代码。此类将视图与模型连接。
您将使用控制器类使计算器执行响应用户事件的操作。您将从以下导入开始：

```python
from functools import partial
```

在 `pycalc.py` 顶部，您导入` partial()`将信号与需要进行额外参数处理的方法连接起来。

您的控制器类需要执行三个主要任务：

1. 访问 `GUI` 的公共接口 
2. 处理数学表达的创建
3. 使用适当的插槽连接单击的按钮信号

```python
# Create a Controller class to connect the GUI and the model
class PyCalcCtrl:
    """PyCalc Controller class."""
    def __init__(self, view):
        """Controller initializer."""
        self._view = view
        # Connect signals and slots
        self._connectSignals()

    def _buildExpression(self, sub_exp):
        """Build expression."""
        expression = self._view.displayText() + sub_exp
        self._view.setDisplayText(expression)

    def _connectSignals(self):
        """Connect signals and slots."""
        for btnText, btn in self._view.buttons.items():
            if btnText not in {'=', 'C'}:
                btn.clicked.connect(partial(self._buildExpression, btnText))

        self._view.buttons['C'].clicked.connect(self._view.clearDisplay)
```

你做的第一件事就是给 `PyCalcCtrl`  一个 `PyCalcUi` 的例子。
您将使用此实例获得对视图公共界面的完全访问权限。
接下来，您创建 `._buildExpression()` 来处理数学表达的创建。
此方法还根据用户输入更新计算器的显示。

最后，您使用 `._connectSignals()` 将可打印按钮与 `._buildExpression()` 连接起来。
这允许您的用户通过单击计算器的按钮创建数学表达式。
在最后一行中，您将清除按钮 （ `C` ） 连接到 `._view.clearDisplay().`。此方法将清除显示屏上的文本。：

```python
# Client code
def main():
    """Main function."""
    # Create an instance of QApplication
    pycalc = QApplication(sys.argv)
    # Show the calculator's GUI
    view = PyCalcUi()
    view.show()
    # Create instances of the model and the controller
    PyCalcCtrl(view=view)
    # Execute calculator's main loop
    sys.exit(pycalc.exec_())
```

此代码创建 `PyCalcCtrl`（视图）实例，该视图作为参数传递。这将初始化控制器并连接信号和插槽，为您的计算器提供一些功能。

正如你所看到的，计算器已经有一些有用的功能！
现在，您可以通过单击按钮来构建数学表达。
请注意，等号符号 （ `+` ） 尚未起作用。
要解决这个问题，您需要实现计算器的模型。

#### 实现模型

模型是处理业务逻辑的代码层。
在这种情况下，业务逻辑完全是关于基本的数学计算。您的模型将评估用户引入的数学表达式。由于模型需要处理错误，您将定义以下全局常量：

```text
ERROR_MSG = 'ERROR'
```

这是用户在引入无效数学表达式时将看到的消息。您的模型将是单个函数：

```python
# Create a Model to handle the calculator's operation
def evaluateExpression(expression):
    """Evaluate an expression."""
    try:
        result = str(eval(expression, {}, {}))
    except Exception:
        result = ERROR_MSG

    return result
```

在这里，您使用 `eval()` 将字符串计算为表达式。如果成功，那么您将返回结果。否则，返回错误消息。请注意，此功能并不完美。它有几个重要的问题：

- `try...except` 块不会捕获任何特定的异常，这不是 `Python` 中的最佳实践。
- 该函数基于 `eval()` 的使用，这可能会导致一些严重的安全问题。一般建议是仅对受信任的输入使用 `eval()`。

您可以自由地重新设计该函数，使其更加可靠和安全。在本教程中，您将按原样使用该函数。


#### 完成控制器

一旦你完成了计算器的模型，你就可以完成控制器。 `PyCalcCtrl` 的最终版本将包含处理计算并确保等号 (`=`) 正常工作的逻辑：

```python
# Create a Controller class to connect the GUI and the model
class PyCalcCtrl:
    """PyCalc's Controller."""
    def __init__(self, model, view):
        """Controller initializer."""
        self._evaluate = model
        self._view = view
        # Connect signals and slots
        self._connectSignals()

    def _calculateResult(self):
        """Evaluate expressions."""
        result = self._evaluate(expression=self._view.displayText())
        self._view.setDisplayText(result)

    def _buildExpression(self, sub_exp):
        """Build expression."""
        if self._view.displayText() == ERROR_MSG:
            self._view.clearDisplay()

        expression = self._view.displayText() + sub_exp
        self._view.setDisplayText(expression)

    def _connectSignals(self):
        """Connect signals and slots."""
        for btnText, btn in self._view.buttons.items():
            if btnText not in {'=', 'C'}:
                btn.clicked.connect(partial(self._buildExpression, btnText))

        self._view.buttons['='].clicked.connect(self._calculateResult)
        self._view.display.returnPressed.connect(self._calculateResult)
        self._view.buttons['C'].clicked.connect(self._view.clearDisplay)
```

首先，向 `init` 函数添加一个新参数。现在该类从模型和视图中接收实例。然后在 `._calculateResult()` 中，您获取显示内容，将其作为数学表达式计算，最后在显示中显示结果。

您还将 `if` 语句添加到 `._buildExpression()` 以检查是否发生错误。如果是这样，那么您清除显示并重新开始一个新的表达式。
最后，在 `._connectSignals()` 中再添加两个连接。
第一个启用等号 (`=`)。第二个确保当用户点击 `Enter`↩ 时，计算器将按预期处理表达式。

要使所有这些代码正常工作，您需要更新 main()：

```python
# Client code
def main():
    """Main function."""
    # Create an instance of `QApplication`
    pycalc = QApplication(sys.argv)
    # Show the calculator's GUI
    view = PyCalcUi()
    view.show()
    # Create instances of the model and the controller
    model = evaluateExpression
    PyCalcCtrl(model=model, view=view)
    # Execute calculator's main loop
    sys.exit(pycalc.exec_())
```

在这里，您的模型包含对 `evaluateExpression()` 的引用。此外， `PyCalcCtrl()` 现在接收两个参数：模型和视图。


