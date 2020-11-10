# ansible 小书

## 基础概念

- (Control node)控制节点

任何装有 `Ansible` 的机器。
您可以从任何控制节点运行命令和剧本，并调用 `/usr/bin/ansible` 或 `/usr/bin/ansible-playbook` 。
您可以将任何安装了 `Python` 的计算机用作控制节点，共享台式机和服务器都可以运行 `Ansible`。
但是，不能将 `Windows` 计算机用作控制节点。
您可以有多个控制节点。

- (Managed nodes) 受控节点

解释：
受控节点指的是：☞您使用 `Ansible` 管理的网络设备（或服务器）。
受控节点有时也称为“主机”。受控节点上没有安装 `Ansible`。


- (Inventory) 清单文件

清单文件指的是：☞受控节点的列表。
清单文件有时也称为“主机文件”。
您的清单可以为每个受管节点指定信息，例如 `IP` 地址。
库存还可以组织受控节点，创建和嵌套组以便于扩展。

- (Module) 模块

指的是：☞`Ansible`的代码执行单元。
从管理特定类型的数据库上的用户到管理特定类型的网络设备上的 `VLAN` 接口，每个模块都有特定的用途。
您可以通过任务调用单个模块，也可以在 `PlayBook`  中调用多个不同的模块。


- (Tasks) 任务 

指的是：☞ `Ansible`中的执行单位。
您可以使用临时命令一次执行一个任务。

- Playbooks (剧本)

已保存任务的有序列表，以便您可以按该顺序重复运行那些任务。
剧本可以包括变量以及任务。
剧本采用 `YAML` 编写，易于阅读，编写，共享和理解。

## 如何构建自定义的清单文件

 `Ansible` 使用称为清单的清单或清单组，同时针对基础架构中的多个受控节点或“主机”进行工作。
定义清单后，您可以使用模式来选择要与 `Ansible` 一起运行的主机或组。

清单默认位置是一个名为 `/etc/ansible/hosts` 的文件。
您可以使用 `-i` 选项在命令行中指定其他清单文件。
您还可以同时使用多个清单文件， 或从动态或云资源或不同格式（ `YAML`，`ini` 等）中提取清单，

### 清单基础：格式，主机和组

清单文件可以采用多种格式中任意一种，具体取决于您拥有的清单插件。
最常见的格式是 `INI` 和 `YAML` 。
基本的 `INI` 格式： `etc/ansible/hosts` 可能看起来像这样：

```ini
mail.example.com

[webservers]
foo.example.com
bar.example.com

[dbservers]
one.example.com
two.example.com
three.example.com
```

括号中的标题是组名，用于对主机进行分类并确定您在什么时候、什么目的 、控制什么主机。

下面是基于 YAML 格式的清单文件：

```yaml
all:
  hosts:
    mail.example.com:
  children:
    webservers:
      hosts:
        foo.example.com:
        bar.example.com:
    dbservers:
      hosts:
        one.example.com:
        two.example.com:
        three.example.com:

```

### 默认组

有两个默认组：全部(`all`)和未分组(`ungrouped`)。
全部组包含每个主机。
未分组的组包含除所有主机之外没有其他组的所有主机。
每个主机将始终至少属于2个组（全部和未分组或全部和某些其他组）。
尽管 `all` 和 `ungrouped` 始终存在，但它们可以是隐式的，不会出现在 `group` 列表之类的 `group_names` 中。

### 多个组中的主机

您可以（可能会）将每个主机分成多个组。
例如，亚特兰大数据中心中的生产 `Web` 服务器可能包含在名为 `[prod]` 和 `[atlanta]` 和 `[webservers]` 的组中。
您可以创建跟踪以下内容的组：

- 应用程序，堆栈或微服务。 （例如，数据库服务器，`Web` 服务器等）。
- 与本地 `DNS` ，存储等进行通信的数据中心 或 域（例如，东部，西部）。
- 在开发阶段，避免对生产资源进行测试。 （例如，生产，测试）。

扩展以前的 `YAML` 清单文件，以包括如下内容，时间和位置：

```yaml
all:
  hosts:
    mail.example.com:
  children:
    webservers:
      hosts:
        foo.example.com:
        bar.example.com:
    dbservers:
      hosts:
        one.example.com:
        two.example.com:
        three.example.com:
    east:
      hosts:
        foo.example.com:
        one.example.com:
        two.example.com:
    west:
      hosts:
        bar.example.com:
        three.example.com:
    prod:
      hosts:
        foo.example.com:
        one.example.com:
        two.example.com:
    test:
      hosts:
        bar.example.com:
        three.example.com:

```
您可以看到 `dbservers`，`east` 和 `prod` 组中存在` one.example.com`。

您也可以使用嵌套组来简化此清单文件中的 `prod` 和 `test`，以获得相同的结果：

```yaml
all:
  hosts:
    mail.example.com:
  children:
    webservers:
      hosts:
        foo.example.com:
        bar.example.com:
    dbservers:
      hosts:
        one.example.com:
        two.example.com:
        three.example.com:
    east:
      hosts:
        foo.example.com:
        one.example.com:
        two.example.com:
    west:
      hosts:
        bar.example.com:
        three.example.com:
    prod:
      children:
        east:
    test:
      children:
        west:
```
### 添加主机范围

如果您有很多具有相似模式的主机，则可以将它们添加为一个范围，而不必分别列出每个主机名：在 `INI` 中：

```ini
[webservers]
www[01:50].example.com

```

对于数字模式，可以根据需求包含或删除前缀零。范围包括在内。您还可以定义字母范围：

```yaml
[databases]
db-[a:f].example.com
```

### 向清单文件添加变量

您可以存储与清单中特定主机或组相关的变量值。
首先，您可以将变量直接添加到主清单文件中的主机和组。
但是，随着将越来越多的受控节点添加到 `Ansible` 清单文件中，您可能希望将变量存储在单独的主机和组变量文件中.

#### 将变量分配给一台计算机：主机变量


您可以轻松地将变量分配给单个主机，然后稍后在剧本中使用它。
在 `INI` 中：
```ini
[atlanta]
host1 http_port=80 maxRequestsPerChild=808
host2 http_port=303 maxRequestsPerChild=909
```

在 `YAML` 中：

```
atlanta:
  host1:
    http_port: 80
    maxRequestsPerChild: 808
  host2:
    http_port: 303
    maxRequestsPerChild: 909

```
诸如非标准 `SSH` 端口之类的唯一值可以很好地用作主机变量。
您可以通过在主机名后加冒号的端口号将它们添加到 `Ansible` 清单中：

```ini
badwolf.example.com:5309
```
连接变量也可以用作主机变量：

```ini
[targets]

localhost              ansible_connection=local
other1.example.com     ansible_connection=ssh        ansible_user=myuser
other2.example.com     ansible_connection=ssh        ansible_user=myotheruser
```
!> 如果在 `SSH` 配置文件中列出了非标准 `SSH` 端口，则 `openssh` 连接将找到并使用它们，而 `paramiko` 连接则不会。

#### 清单别名

您还可以在清单文件中定义别名：

在 `INI` 格式文件中 ：

```ini
jumper ansible_port=5555 ansible_host=192.0.2.50

```

在 `YAML` 格式文件中：

```yaml

...
  hosts:
    jumper:
      ansible_port: 5555
      ansible_host: 192.0.2.50

```
 在上面的示例中，对主机别名“ jumper”运行 `Ansible` 将连接到 `192.0.2.50` 上的 `5555` 端口 。这仅适用于具有静态 `IP` 的主机，
或者通过隧道连接时。

!> - 使用 `key=value` 语法以`INI` 格式传递的值根据声明位置的不同而具有不同地解释：
!> - 当与主机内联声明时，`INI` 值将解释为 `Python` 字面量结构（字符串，数字，元组，列表，字典，布尔值，空）。
主机行每行接受多个 `key=value` 参数。
因此，他们需要一种方法来指示空格是值的一部分而不是分隔符。
!> - 在 `:vars` 节中声明时，`INI` 值将解释为字符串。
例如，`var=FALSE` 将创建一个等于 "FALSE" 的字符串。
与主机行不同，`:vars` 节每行仅接受一个条目，因此`=`号之后的所有内容都必须是该条目的值。
!> - 如果 `INI` 清单中设置的变量值必须是某种类型（例如，字符串或布尔值），请始终在任务中使用过滤器指定类型。
使用变量时，请勿依赖 `INI` 清单中设置的类型。
!> - 考虑将 `YAML` 格式用于清单文件，以避免混淆变量的实际类型。 
`YAML` 清单文件插件可以一致且正确地处理变量值。

通常，这不是定义描述系统策略的变量的最佳方法。
在主清单文件中设置变量只是一种简写。

####  将变量分配给许多计算机：组变量
 
如果组中的所有主机共享一个变量值，则可以一次将该变量应用于整个组。
在 `INI` 中：

```ini

[atlanta]
host1
host2

[atlanta:vars]
ntp_server=ntp.atlanta.example.com
proxy=proxy.atlanta.example.com

```

 在 `YAML` 中:

```yaml

atlanta:
  hosts:
    host1:
    host2:
  vars:
    ntp_server: ntp.atlanta.example.com
    proxy: proxy.atlanta.example.com

```

组变量是一次将变量应用于多个主机的便捷方法。
但是，在执行之前，`Ansible` 始终将变量（包括清单变量）展平到主机级别。
如果主机是多个组的成员，则 `Ansible` 将从所有这些组中读取变量值。
如果将不同的值分配给不同组中的同一变量，则 `Ansible` 会根据内部规则选择要使用的值进行合并。

#### 继承变量值：组中组的组变量

您可以使用 `INI` 中的 `:children` 后缀或 `YAML` 中的 `children:` 条目进行分组。
您可以使用：`vars` 或 `vars::` 将变量应用于这些组。

在 `INI` 中：

```ini
[atlanta]
host1
host2

[raleigh]
host2
host3

[southeast:children]
atlanta
raleigh

[southeast:vars]
some_server=foo.southeast.example.com
halon_system_timeout=30
self_destruct_countdown=60
escape_pods=2

[usa:children]
southeast
northeast
southwest
northwest
```
在 `YAML` 中:

```yaml

all:
  children:
    usa:
      children:
        southeast:
          children:
            atlanta:
              hosts:
                host1:
                host2:
            raleigh:
              hosts:
                host2:
                host3:
          vars:
            some_server: foo.southeast.example.com
            halon_system_timeout: 30
            self_destruct_countdown: 60
            escape_pods: 2
        northeast:
        northwest:
        southwest:

```


如果您需要存储列表或哈希数据，或者希望将主机和组特定变量与清单文件分开，请参阅组织主机和组变量。

子组有几个要注意的属性：

- 属于子组成员的任何主机都将自动成为父组成员。
- 子组变量将具有更高的优先级（覆盖）父组变量。
- 组可以有多个父组和子组，但不能有循环关系。
- 主机也可以位于多个组中，但是只有一个主机实例，可以合并多个组中的数据


