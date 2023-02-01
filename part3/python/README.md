## 什么是 package

包”本质上是一个模块，它可以在其中包含其他模块（实际上还有其他包）。

一个包通常对应一个目录，其中有一个名为 `__init__.py` 的文件和任意数量的 `python` 文件或其他包目录：

```text
a_package
   __init__.py
   module_a.py
   a_sub_package
     __init__.py
     module_b.py
```

`__init__.py` 可以完全是空的——或者它可以包含任意 python 代码。
代码将在导入包时运行——就像模块一样， 包内的模块不会自动导入。所以，在上面的结构基础上：

```python
import a_package

```

将运行 `a_package/__init__.py` 中的代码。 `__init__.py` 中定义的任何名称都将在以下位置可用：

```python
a_package.a_name
```

然而

```python
a_package.module_a
```

module_a 不存在
这种方式不可以，要换一种方式

要获取子模块，您需要显式导入它们：

```python
import a_package.module_a


```

详见文档： https://docs.python.org/3/tutorial/modules.html#packages

### 包搜索路径

当您执行导入时，解释器会保留它查找模块或包的所有位置的列表：

```python
import sys

for p in sys.path:
    print
p

```

![img.png](img.png)

您可以操纵该列表来添加或删除路径，让 `python` 在新位置查找模块。 每个模块都有一个 `__file__`
名称，指向它所在的路径。这使您可以添加相对于您所在位置的路径等。

> !注意：通常最好使用 setuptools 的“开发”模式——见下文。

### 构建你自己的包

构建自己的包裹所需了解的基础知识。

#### 为什么要构建一个包？

有很多漂亮的工具可以帮助您构建、安装和分发包。
为您的包使用结构良好的标准布局可以轻松使用这些工具。
即使您不想将您的代码提供给任何其他人，结构良好的包也可以简化开发。

#### package 是什么》？

- 模块集合
- ……文档
- ......测试
- ...任何顶级脚本
- ……以及所需的任何数据文件
- ……以及构建安装它的方法……

#### `Python` 打包工具

##### distutils

distutils：包含在 `python` 中

```python
from distutils.core import setup
```

变得笨拙，难以扩展，也许注定要弃用……
扩展程序选项

##### setuptools

[Building and Distributing Packages with Setuptools - setuptools 67.0.0.post20230128 documentation](https://setuptools.pypa.io/en/latest/setuptools.html)

`Setuptools` 是 `distutils` 的扩展，它提供了许多扩展

例如：

- 自动查找包

- 更好的脚本安装

- 资源（非代码文件）管理

- 开发模式

- 更多

#### 如何搞懂

用户手册

https://packaging.python.org/

更加详细的

http://python-packaging.readthedocs.io/en/latest/

（这具有您可能需要的所有复杂性……） 您可以将其用作您自己的包的模板。 这是一个自以为是的更新——有点花哨，但有一些好主意：

https://blog.ionelmc.ro/2014/05/25/python-packaging/

基础的结构：

```text
package_name/
    bin/
    CHANGES.txt
    docs/
    LICENSE.txt
    MANIFEST.in
    README.txt
    setup.py
    package_name/
          __init__.py
          module1.py
          module2.py
          test/
              __init__.py
              test_module1.py
              test_module2.py
```

- CHANGES.txt：每个版本的更改日志

- LICENSE.txt：您选择的许可证文本（请选择一个！

- MANIFEST.in：描述要包含哪些非代码文件

- README.txt：包的描述 – 应该用 `ReST` 或 Markdown 编写（对于 `PyPi`）：

- setup.py：用于构建/安装包的脚本 `package_name` 。此处的选项：
- `bin/`：这是你放置顶级脚本的地方 （有些人使用 `scripts` ）
- `docs/`：文档
- `package_name/`：主包 - 这是代码入口。此处的选项：

放入包——支持

```text
$ pip install package_name
>> import package_name.test
>> package_name.test.runall()
```

或者保持在顶层。 一些注意事项：

[Where to Put Tests? — Python Topics 1.0.0 documentation](http://pythonchb.github.io/PythonTopics/where_to_put_tests.html)

##### setup.py 文件

您的 `setup.py` 文件描述了您的包，并告诉 `setuptools` 如何打包、构建和安装它 它是 `python` 代码，所以你可以添加任何你需要的自定义代码
但在简单的情况下，它本质上是声明性的。

http://docs.python.org/3/distutils/

##### setup.py 有什么作用？

- 版本和包元数据
- 要包含的包列表
- 要包含的其他文件列表
- 依赖列表
- 要编译的扩展列表（如果你没有使用 [scikit-build](https://scikit-build.org/).

###### 示例

setup.py

```python
 from setuptools import setup

setup(
    name='PackageName',
    version='0.1.0',
    author='An Awesome Coder',
    author_email='aac@example.com',
    packages=['package_name', 'package_name.test'],
    scripts=['bin/script1', 'bin/script2'],
    url='http://pypi.python.org/pypi/PackageName/',
    license='LICENSE.txt',
    description='An awesome package that does something',
    long_description=open('README.txt').read(),
    install_requires=[
        "Django >= 1.1.1",
        "pytest",
    ],
)
```

setup.cfg

提供一种方法，使最终用户能够自定义安装 这是一个 `ini` 样式文件

```text
[command]
option=value
...
```

易于读写。 命令是 Distutils 命令之一（例如 build_py、install） 选项是命令支持的选项之一。 请注意，命令行上拼写为 `--foo-bar`
的选项在配置文件中拼写为 `foo_bar`。

##### 运行 setup.py

通过定义 setup.py 脚本，setuptools 可以做很多事情： 构建源代码分发（构建和安装包所需的所有文件的 tar 存档）：

```shell
python setup.py sdist
```

造轮子：

```shell
./setup.py bdist_wheel

```

（你需要 `wheel` 包才能工作：）

```shell
pip install wheel
```

从源代码构建：

```shell
python setup.py build
```

然后安装

```shell
python setup.py install
```

#### 开发模式

在“开发”或“可编辑”模式下安装：

```shell
python setup.py develop

```

或者

```shell
pip install .

```

正在开发中 开发模式真的非常好：

```shell
$ python setup.py develop
```

或

```shell
$ pip install -e ./
```

（`e` 代表“可编辑的” - 这是一回事）

它把一个链接（实际上是`*.pth`文件）放到 `python` 安装到你的代码，这样你的包就被安装好了，但任何更改都会立即生效。
这样，您所有的测试代码和客户端代码等都可以按照通常的方式导入您的包。 没有 `sys.path` 黑客攻击

将它用于单个文件项目之外的任何东西都是个好主意。

| 安装	            | 开发安装                                |
|----------------|-------------------------------------|
| 将包复制到站点包中      | 将 `.pth` 文件添加到站点包，指向包源根目录           
| 创建 conda 包时使用	 | 在本地开发软件时使用                          
| 系统路径中的正常优先级    | 	`sys.path` 的结束（只有在没有其他先出现的情况下才能找到） 

https://grahamwideman.wikispaces.com/Python-+site-package+dirs+and+.pth+files

##### 除了 pip 和依赖项

- pip 目前没有求解器：http://github.com/pypa/pip/issues/988

- pip 可能会将您环境中的软件包替换为不兼容的版本。当这种情况发生时，事情会破裂

- 使用pip时要小心（理想情况下，一次性环境）

开始使用新包

对于除单文件脚本以外的任何内容（甚至可能如此）：

##### 创建基本包结构

- 编写 setup.py

- `pip install -e .`

- 将一些测试放入`包/测试`

- pytest 在测试目录或 `pytest --pyargs package_name`

或使用“饼切”：

https://cookiecutter.readthedocs.io/en/latest/

##### 练习：一个小示例包

创建一个小包

- 包结构

- `setup.py`

- `python setup.py develop`

至少一个工作测试

从教程存储库中的愚蠢代码开始：

`python-packaging-tutorial/setup_example/`

首字母大写是一个无用的小工具，将大写的文字在文本文件。但它具有 `python` 包的核心结构:逻辑代码库、命令行脚本和数据文件测试

```shell
$ ls
capital_mod.py           test_capital_mod.py
cap_data.txt             main.py
cap_script.py            sample_text_file.txt
```

这些文件是什么？

- capital_mod.py

  - 核心逻辑代码

- main.py

  - 命令行应用

- test_capital_mod.py

  - 逻辑测试代码

- cap_script.py

  - 顶级脚本

- cap_data.txt

  - 数据文件

- sample_text_file.txt

  - 测试的示例文件

试用：

```shell
$ cd capitalize/

$ python3 cap_script.py sample_text_file.txt

Capitalizing: sample_text_file.txt and storing it in
sample_text_file_cap.txt

I'm done
```
设置包结构

创建一个基本的包结构：

```text
package_name/
    bin/
    README.txt
    setup.py
    package_name/
          __init__.py
          module1.py
          test/
              __init__.py
              test_module1.py
```

让我们为大写创建所有内容： 制作包裹：

```shell
$ mkdir capitalize

$ cd capitalize/

$ touch __init__.py
```
将代码移入其中：

```shell
    $ mv ../capital_mod.py ./
$ mv ../main.py ./
```

为测试创建一个目录：
```shell
mkdir test
```
将测试移入其中：

```shell
$ mv ../test_capital_mod.py test/

```

为脚本创建一个目录：

```shell
$ mkdir bin
```

将脚本移动到其中：

```shell
$ mv ../cap_script.py bin

```
为数据创建目录：

```shell
$ mkdir data

```
将数据移入其中：

```shell
$ mv ../cap_data.txt data
```

现在我们有一个 `package` ！ 让我们试试看：

```shell
$ python bin/cap_script.py
Traceback (most recent call last):
  File "bin/cap_script.py", line 8, in <module>
    import capital_mod
ImportError: No module named capital_mod
```
好的，那没有用。为什么不？ 好吧，我们已经四处移动了： 模块不知道如何找到彼此。


让我们写一个 setup.py

```python
#!/usr/bin/env python

from setuptools import setup

setup(name='capitalize',
      version='1.0',
      # list folders, not files
      packages=['capitalize',
                'capitalize.test'],
      scripts=['capitalize/bin/cap_script.py'],
      package_data={'capitalize': ['data/cap_data.txt']},
      )
```
（请记住，“包”是一个包含 `__init__.py__` 文件的文件夹） 这是你能做的最低限度。 将其另存为 `capitalize` 包目录外的 `setup.py`。 以“可编辑”模式安装它：

```shell
$ pip install -e ./
Obtaining file:///Users/chris.barker/HAZMAT/Conferences/SciPy-2018/PackagingTutorial/TutorialDay/capitalize
Installing collected packages: capitalize
  Running setup.py develop for capitalize
Successfully installed capitalize
```

试试看

```shell
$ cap_script.py
Traceback (most recent call last):
  File "/Users/chris.barker/miniconda2/envs/py3/bin/cap_script.py", line 6, in <module>
    exec(compile(open(__file__).read(), __file__, 'exec'))
  File "/Users/chris.barker/HAZMAT/Conferences/SciPy-2018/PackagingTutorial/TutorialDay/capitalize/capitalize/bin/cap_script.py", line 8, in <module>
    import capital_mod
ModuleNotFoundError: No module named 'capital_mod'
```
仍然没有用——为什么不？ 我们需要更新一些导入。

在  cap_script.py:

```python
import main
import capital_mod
```

应该：

```python
from capitalize import main
from capitalize import capital_mod
```
同样在 main.py 中：

```python
from capitalize import capital_mod
```
然后重试

```shell
$ cap_script.py sample_text_file.txt

      Traceback (most recent call last):
File ".../cap_script.py", line 6, in <module>
  exec(compile(open(__file__).read(), __file__, 'exec'))
File ".../cap_script.py", line 8, in <module>
  from capitalize import capital_mod
File "/.../capital_mod.py", line 35, in <module>
  special_words = load_special_words(get_datafile_name())
File ".../capital_mod.py", line 21, in load_special_words
  with open(data_file_name) as data_file:
FileNotFoundError: [Errno 2] No such file or directory: '.../capitalize/cap_data.txt'
```
我们的脚本找不到数据文件。我们更改了它的位置，但没有更改 `capital_mod.py` 中的路径。
让我们解决这个问题。在第 32 行替换：

```python
return Path(__file__).parent / "cap_data.txt"
```
为 

```python
return Path(__file__).parent / "data/cap_data.txt"
```
##### 运行测试

选项1 切换到测试目录

```shell
$ cd capitalize/test/

$ pytest
$ ===================================
  test session starts
  ====================================
...

Traceback:
test_capital_mod.py:14: in <module>
    import capital_mod
E   ModuleNotFoundError: No module named 'capital_mod'
```
哎呀——我们也需要修复那个导入：

```python
from capitalize import capital_mod
```
现在就可以了

```shell
$ pytest
======test session starts =====

collected 3 items

test_capital_mod.py ...

============== 3 passed in 0.06 seconds ============
```
您还可以从命令行的任何位置运行测试：

```shell
$ pytest --pyargs capitalize

    collected 3 items

    capitalize/capitalize/test/test_capital_mod.py ...                                   [100%]

    =============== 3 passed in 0.03 seconds ==========
```
构建包的简单方法

您可以使用漂亮的“饼切”项目，而不是手动完成

https://cookiecutter.readthedocs.io/en/latest/

并且有一些模板可以与之一起使用。 作者编写的核心模板：

https://github.com/audreyr/cookiecutter-pypackage

还有一篇由上面自以为是的博客文章的作者写的：

https://github.com/ionelmc/cookiecutter-pylibrary

两者都是很好的起点。

```shell

conda install -c conda-forge cookiecutter
```
或者

```shell
pip install  cookiecutter
```
现在没时间了:-(

##### 处理要求 

只有最简单的包才需要 `Python` 标准库。

setup.py 中的要求

```shell
#!/usr/bin/env python
from distutils.core import setup

setup(name='mypkg',
      version='1.0',
      # list folders, not files
      packages=['mypkg', 'mypkg.subpkg'],
      install_requires=['click'],
      )
```
requirements.txt 中的需求

常见的错误： 

- requirements.txt 通常来自 pip freeze 钉得太紧了。
- 可以创建环境，但不适合打包。


- Donald Stufft（PyPA）https://caremad.io/posts/2013/07/setup-vs-requirement


##### setup.cfg 中的要求（理想）

```ini
[metadata]
name = my_package
version = attr:
src.VERSION

[options]
packages = find:
install_requires = click
```
无需执行即可解析，与 setup.py 不同

http://setuptools.readthedocs.io/en/latest/setuptools.html#configuring-setup-using-setup-cfg-files

休息时间！
