# ansible 小书

!> 参考文档: https://docs.ansible.com/ansible/2.9/user_guide, 版本  2.9 , 整理原因： 为考试准备

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
受控节点有时也称为“宿主”。受控节点上没有安装 `Ansible`。


- (Inventory) 清单文件

清单文件指的是：☞受控节点的列表。
清单文件有时也称为“宿主文件”。
您的清单可以为每个受管节点指定信息，例如 `IP` 地址。
清单还可以组织受控节点，创建和嵌套组以便于扩展。

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

 `Ansible` 使用称为清单的清单或清单组，同时针对基础架构中的多个受控节点或“宿主”进行工作。
定义清单后，您可以使用模式来选择要与 `Ansible` 一起运行的宿主或组。

清单默认位置是一个名为 `/etc/ansible/hosts` 的文件。
您可以使用 `-i` 选项在命令行中指定其他清单文件。
您还可以同时使用多个清单文件， 或从动态或云资源或不同格式（ `YAML`，`ini` 等）中提取清单，

### 清单基础：格式，宿主和组

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

括号中的标题是组名，用于对宿主进行分类并确定您在什么时候、什么目的 、控制什么主机。

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
全部组包含每个宿主。
未分组的组包含除所有宿主之外没有其他组的所有主机。
每个宿主将始终至少属于2个组（全部和未分组或全部和某些其他组）。
尽管 `all` 和 `ungrouped` 始终存在，但它们可以是隐式的，不会出现在 `group` 列表之类的 `group_names` 中。

### 多个组中的宿主

您可以（可能会）将每个宿主分成多个组。
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
### 添加宿主范围

如果您有很多具有相似模式的宿主，则可以将它们添加为一个范围，而不必分别列出每个主机名：在 `INI` 中：

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

您可以存储与清单中特定宿主或组相关的变量值。
首先，您可以将变量直接添加到主清单文件中的宿主和组。
但是，随着将越来越多的受控节点添加到 `Ansible` 清单文件中，您可能希望将变量存储在单独的宿主和组变量文件中.

#### 将变量分配给一台计算机：宿主变量


您可以轻松地将变量分配给单个宿主，然后稍后在剧本中使用它。
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
诸如非标准 `SSH` 端口之类的唯一值可以很好地用作宿主变量。
您可以通过在宿主名后加冒号的端口号将它们添加到 `Ansible` 清单中：

```ini
badwolf.example.com:5309
```
连接变量也可以用作宿主变量：

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
 在上面的示例中，对宿主别名“ jumper”运行 `Ansible` 将连接到 `192.0.2.50` 上的 `5555` 端口 。这仅适用于具有静态 `IP` 的主机，
或者通过隧道连接时。

!> 
- 使用 `key=value` 语法以`INI` 格式传递的值根据声明位置的不同而具有不同地解释：

- 当与宿主内联声明时，`INI` 值将解释为 `Python` 字面量结构（字符串，数字，元组，列表，字典，布尔值，空）。
宿主行每行接受多个 `key=value` 参数。
因此，他们需要一种方法来指示空格是值的一部分而不是分隔符。

- 在 `:vars` 节中声明时，`INI` 值将解释为字符串。
例如，`var=FALSE` 将创建一个等于 "FALSE" 的字符串。
与宿主行不同，`:vars` 节每行仅接受一个条目，因此`=`号之后的所有内容都必须是该条目的值。

- 如果 `INI` 清单中设置的变量值必须是某种类型（例如，字符串或布尔值），请始终在任务中使用过滤器指定类型。
使用变量时，请勿依赖 `INI` 清单中设置的类型。

- 考虑将 `YAML` 格式用于清单文件，以避免混淆变量的实际类型。 
`YAML` 清单文件插件可以一致且正确地处理变量值。

!> 


通常，这不是定义描述系统策略的变量的最佳方法。
在主清单文件中设置变量只是一种简写。

####  将变量分配给许多计算机：组变量
 
如果组中的所有宿主共享一个变量值，则可以一次将该变量应用于整个组。
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

组变量是一次将变量应用于多个宿主的便捷方法。
但是，在执行之前，`Ansible` 始终将变量（包括清单变量）展平到宿主级别。
如果宿主是多个组的成员，则 `Ansible` 将从所有这些组中读取变量值。
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


如果您需要存储列表或哈希数据，或者希望将宿主和组特定变量与清单文件分开，请参阅组织主机和组变量。

子组有几个要注意的属性：

- 属于子组成员的任何宿主都将自动成为父组成员。
- 子组变量将具有更高的优先级（覆盖）父组变量。
- 组可以有多个父组和子组，但不能有循环关系。
- 宿主也可以位于多个组中，但是只有一个主机实例，可以合并多个组中的数据

###  管理宿主和组变量

尽管我们可以将变量存储在主清单文件中，但存储单独的宿主变量和组变量文件可以帮助您更轻松地管理变量值。
- 宿主和组变量文件必须使用 ` YAM ` L语法。
- 有效的文件扩展名包括` .yml `，` .yaml `，`.json `或 `没有文件扩展名`。
- 如果您不熟悉 `YAML` ，请参见 `YAML` 语法。 

` Ansible `  通过搜索相对于清单文件或剧本文件的路径来加载宿主和组变量文件。

如果位于 `/etc/ansible/hosts` 的清单文件包含名为 `foosball` 的宿主，该主机属于 `raleigh` 和 `webservers` 两个组，则该主机将在YAML文件中使用变量：


```yml
/etc/ansible/group_vars/raleigh #  可选的文件拓展名： '.yml', '.yaml', 或  '.json'
/etc/ansible/group_vars/webservers
/etc/ansible/host_vars/foosball
```

例如，如果按数据中心将清单中的宿主们分组，并且每个数据中心使用其自己的 `NTP` 服务器和数据库服务器，则可以创建一个名为 `/etc/ansible/group_vars/raleigh` 的文件来存储 `raleigh` 组的变量：

```yml
/etc/ansible/group_vars/raleigh/db_settings
/etc/ansible/group_vars/raleigh/cluster_settings
```

`raleigh`  组中的所有宿主都可以使用这些文件中定义的变量。
当单个文件太大或要在某些组变量上使用 `Ansible Vault` 时，这对于保持变量的组织性非常有用。

您还可以将 `group_vars/` 和 `host_vars/` 目录添加到您的剧本目录中。
缺省情况下，`ansible-playbook` 命令在当前工作目录中查找这些目录。
其他 `Ansible` 命令（例如，`ansible` ，`ansible-console` 等）将仅在清单目录中查找 `group_vars`  /和 `host_vars/` 。
如果要其他命令从剧本目录加载组和宿主变量，则必须在命令行上提供 `--playbook-dir` 选项。
如果您同时从 `Playbook` 目录和清单目录中加载清单文件，则 `Playbook` 目录中的变量将覆盖在清单目录中设置的变量。
将清单文件和变量保存在 `git repo` （或其他版本控制工具）中，是跟踪清单和宿主变量的更改的绝佳方法。


### 变量是如何合并的？ 

默认情况下，在运行剧本之前，变量会合并或延展到指定宿主。
这使得 `Ansible` 可以专注于宿主和任务，因此组无法真正在清单文件和除匹配的主机之外的环境中存活。
默认情况下，`Ansible` 会覆盖变量，包括为组或宿主定义的变量.
顺序或优先顺序是（从最低到最高）：

- 所有组（因为它是所有其他组的根）
- 父级组
- 子级组
- 宿主


默认情况下，`Ansible` 按字母顺序合并处于相同父或子级别的组，最后加载的组将覆盖先前的组。
例如， `a_group` 将与 `b_group` 合并，并且匹配的 `b_group` 变量将覆盖 `a _group` 中的变量。
您可以通过设置组变量 `ansible_group_priority` 更改同一级别的组的合并顺序（在解决父或子顺序之后）来更改此行为。
数字越大，合并的时间越晚，优先级更高。
如果未设置，则此变量默认为 `1`。
例如：

> priority 表示的优先级，如果你写过java 那么你应该很熟悉这个单词

```yml
    testvar: a
    ansible_group_priority: 10
b_group:
    testvar: b
```

在此示例中，如果两个组具有相同的优先级，则结果通常为 `testvar == b`  ，但是由于我们给 `a_group` 一个更高的优先级，因此结果将为 `testvar == a` 。

!> `ansible_group_priority` 只能在清单源中设置，而不能在 `group_vars/` 中设置，因为该变量用于加载 `group_vars` 。

### 使用多个清单源

通过从命令行提供多个清单参数或通过配置 `ANSIBLE_INVENTORY`  ，可以同时定位多个清单源（目录，动态清单脚本或清单插件支持的文件）。
当您要针对特定操作同时针对通常独立的环境（例如预发布和生产环境）时，这还是很有用的。

从命令行定位两个源，如下所示：

```bash
ansible-playbook get_logs.yml -i staging -i production

```

请记住，如果清单中存在变量冲突，则根据[如何合并变量和变量优先级](https://docs.ansible.com/ansible/2.9/user_guide/intro_inventory.html#how-we-merge)：我[应该在哪里放置变量](https://docs.ansible.com/ansible/2.9/user_guide/playbooks_variables.html#ansible-variable-precedence)中所述的规则解决这些冲突。

合并顺序由清单源参数的顺序控制。
如果预发布环境清单中的 `[all：vars]` 定义 `myvar = 1` ，而生产环境清单中定义 `myvar = 2` ，则将以 `myvar = 2` 运行该剧本。如果以 `-i production -i staging` 运行该剧本，则结果将相反。

#### 用目录汇总清单源

您还可以通过组合目录下的多个清单源和来源类型来创建清单文件。
这对于组合静态和动态宿主并将它们作为一个清单进行管理很有用。
以下清单结合了清单插件源，动态清单脚本和具有静态宿主的文件：

```yml
inventory/
  openstack.yml          # 配置清单插件以从Openstack Cloud 获取宿主们 
  dynamic-inventory.py   # 使用动态清单脚本添加其他宿主
  static-inventory       # 添加静态宿主和组
  group_vars/
    all.yml              # 将变量分配给所有宿主
```

您可以像下面这样定位此清单目录：

```
ansible-playbook example.yml -i inventory
```

如果存在与其他清单源之间的变量冲突或组依赖关系，则控制清单资源的合并顺序会很有用。
根据文件名按字母顺序合并清单，因此可以通过在文件名之前添加前缀来控制结果：

```yml

inventory/
  01-openstack.yml          # 配置清单插件以从 Openstack Cloud 获取宿主 
  02-dynamic-inventory.py   # 使用动态清单脚本添加其他宿主
  03-static-inventory       # 添加静态宿主和组 
  group_vars/
  all.yml                   # 将变量分配给所有宿主


```

如果 `01-openstack.yml` 为所有组定义了 `myvar = 1` ，`02-dynamic-inventory.py` 定义 `myvar = 2` ，而 `03-static-inventory` 定义 `myvar = 3` ，则将以 `myvar = 3` 运行该剧本。

### 连接到宿主：行为清单参数

#### 宿主连接：

!> 当使用 `ssh` 连接插件（默认设置）时，`Ansible` 不会公开允许用户和 `ssh` 进程之间通信的通道，以手动接受密码来解密 `ssh` 密钥。
强烈建议使用 `ssh-agent` 。

- ansible_connection

宿主的连接类型。
可以是任何 `ansible` 连接插件的名称。 
SSH协议类型为 `smart`，`ssh` 或 `paramiko` 。
默认为 `smart` 。
下一节将介绍基于非 `SSH` 的类型。

所有连接的常规参数：

- ansible_host
- 要连接的宿主名，如果与您要给它提供的别名不同。
- ansible_port
- 连接端口号（如果不是默认值）（ssh为22）
- ansible_user
- 连接到宿主时要使用的用户名
- ansible_password
- 用于验证宿主的密码（切勿以纯文本形式存储此变量；建议使用 vault

特定于SSH连接：

- ansible_ssh_private_key_file
 ssh使用的私钥文件。如果使用多个密钥并且您不想使用 `SSH` 代理，则很有用。
- ansible_ssh_common_args
 此设置始终附加到 `sftp` ，`scp` 和 `ssh` 的默认命令行中。为特定宿主（或组）配置 `ProxyCommand` 很有用。
- ansible_sftp_extra_args
 此设置始终附加在默认的 `sftp` 命令行中。
- ansible_scp_extra_args
 此设置始终附加在默认的 `scp` 命令行中。
- ansible_ssh_extra_args
 此设置始终附加在默认的 `ssh` 命令行中。
- ansible_ssh_pipelining 
 确定是否使用 `SSH` 管道。这可以覆盖 `ansible.cfg` 中的管道设置。
- ansible_ssh_executable 
此设置将覆盖使用系统 `ssh` 的默认行为。这可以覆盖 `ansible.cfg` 中的 `ssh_executable` 设置。

`Ansible-INI` 宿主文件中的示例：


```yml

some_host         ansible_port=2222     ansible_user=manager
aws_host          ansible_ssh_private_key_file=/home/example/.ssh/aws.pem
freebsd_host      ansible_python_interpreter=/usr/local/bin/python
ruby_module_host  ansible_ruby_interpreter=/usr/bin/ruby.1.9.3


```

非SSH连接类型

如上一节所述，`Ansible` 通过 `SSH` 执行剧本，但不限于此连接类型。
使用宿主特定的参数 `ansible_connection=<connector> ` ，可以更改连接类型。
以下基于非 `SSH` 的连接器可用：

- local
该连接器可用于将剧本部署到控制宿主（节点）本身。
- docker
该连接器使用本地 `Docker` 客户端将剧本直接部署到 `Docker` 容器中。
此连接器处理以下参数：
- ansible_host
要连接的Docker容器的名称
- ansible_user
在容器内操作的用户名。用户必须存在于容器内。
- ansible_become
如果设置为 `true` ，则会使用 `begin_user` 在容器内进行操作。
- ansible_docker_extra_args

可能是一个字符串，其中包含 `Docker` 可以理解的，不是特定于命令行的任何其他参数。此参数主要用于配置要使用的远程 `Docker` 守护程序。

这是如何立即部署到创建的容器的示例：


```yml

- name: create jenkins container
  docker_container:
    docker_host: myserver.net:4243
    name: my_jenkins
    image: jenkins

- name: add container to inventory
  add_host:
    name: my_jenkins
    ansible_connection: docker
    ansible_docker_extra_args: "--tlsverify --tlscacert=/path/to/ca.pem --tlscert=/path/to/client-cert.pem --tlskey=/path/to/client-key.pem -H=tcp://myserver.net:4243"
    ansible_user: jenkins
  changed_when: false

- name: create directory for ssh keys
  delegate_to: my_jenkins
  file:
    path: "/var/jenkins_home/.ssh/jupiter"
    state: directory

```

!> 如果您从一开始就阅读文档，那么这可能是您看到的 `Ansible` 剧本的第一个示例。
这不是清单文件。
稍后将在文档中详细介绍剧本。


### 清单安装示例

示例：每个环境一个清单

如果您需要管理多个环境，有时明智的做法是每个清单文件只定义一个环境的宿主。
这样，例如，当您实际要更新某些预发布环境的服务器时，很难意外地更改测试环境中节点的状态。
例如：你可以编写一个 `inventory_test ` 文件

```ini

[dbservers]
db01.test.example.com
db02.test.example.com

[appservers]
app01.test.example.com
app02.test.example.com
app03.test.example.com

```
该文件仅包含属于测试环境的宿主。

当然，你可以在另一个文件中定义预发布环境的配置，例如，编写一个 `inventory_staging` 文件：

```ini

[dbservers]
db01.staging.example.com
db02.staging.example.com

[appservers]
app01.staging.example.com
app02.staging.example.com
app03.staging.example.com

```
要将名为 `site.yml` 的剧本应用于测试环境中的所有应用服务器，请使用以下命令

```bash
ansible-playbook -i inventory_test site.yml -l appservers
```

示例：按功能分组

在上一节中，您已经看到了使用组对具有相同功能的宿主进行集群配置的示例。
例如，这使您可以在剧本或角色中定义防火墙规则，而不会影响数据库服务器：

```yml

- hosts: dbservers
  tasks:
  - name: allow access from 10.0.0.1
    iptables:
      chain: INPUT
      jump: ACCEPT
      source: 10.0.0.1

```

示例：按位置分组


其他任务可能集中在某个宿主所在的位置。
假设 `db01.test.example.com` 和 `app01.test.example.com` 位于 `DC1` 中，而 `db02.test.example.com` 位于 `DC2` 中：

```ini
[dc1]
db01.test.example.com
app01.test.example.com

[dc2]
db02.test.example.com
```

实际上，您可能甚至需要混淆所有这些设置，因为有可能，需要在一天之内，更新特定数据中心中的所有节点，而在另一天，无论如何都要更新所有应用程序服务器。

## Ansible ad-hoc （临时）命令


Ansible `ad-hoc` 命令使用 `/usr/bin/ansible` 命令行工具来自动化一个或多个受控节点上的单个任务。
临时命令既快速又简单，但不可重用。
那么，为什么要首先了解临时命令呢？
临时命令演示了 Ansible的简单性和强大。
您在此处学习的概念可直接移植到剧本语言。


### 为何使用

临时命令非常适合很少且重复执行的任务。
例如，如果你想在圣诞节假期关闭实验室中所有机器的电源，则可以在 `Ansible` 中执行快速的单行任务而无需编写剧本。



临时命令如下所示：

```bash

$ ansible [pattern] -m [module] -a "[module options]"

```

### 临时任务的用例


临时任务可用于重新引导服务器，复制文件，管理程序包和用户等。
您可以在临时任务中使用任何 `ansible` 模块。
临时任务（例如剧本）使用声明性模型，计算并执行达到指定最终状态所需的操作。
通过在开始之前检查当前状态并且不执行任何操作，除非当前状态与指定的最终状态不同，它们可以实现幂等形式。

#### 重新启动服务器

`ansible` 命令行实用程序的默认模块是命令模块。
您可以使用临时任务来调用命令模块，然后一次重新启动亚特兰大的所有 `Web` 服务器，每次10个。
在 `Ansible` 执行此操作之前，必须在清单中名为 `[atlanta]` 的组中列出亚特兰大的所有服务器，并且该组中的每台计算机都必须具有有效的 `SSH` 凭据。
要重新启动 `[atlanta]` 组中的所有服务器：

```bash
$ ansible atlanta -a "/sbin/reboot"

```

默认情况下，`Ansible` 仅使用5个并发进程。
如果您拥有的宿主数量超过为派生计数设置的值，则 `Ansible` 会与它们对话，但是会花费更长的时间。
要使用10个并行分支重新启动 `[atlanta]` 服务器，请执行以下操作：

```bash
$ ansible atlanta -a "/sbin/reboot" -f 10
```

`/usr/bin/ansible` 将默认从您的用户帐户运行。要以其他用户身份连接：

```bash
$ ansible atlanta -a "/sbin/reboot" -f 10 -u username
```

重新引导可能需要特权升级。
您可以使用用户名连接到服务器，并使用 `root` 关键字以 `root` 用户身份运行命令：


```bash
$ ansible atlanta -a "/sbin/reboot" -f 10 -u username --become [--ask-become-pass]
```

如果添加 `--ask-become-pass` 或 `-K` ，则 `Ansible` 会提示您输入用于特权升级的密码（ `sudo/su/pfexec/doas/etc`）。

!> 命令模块不支持管道化和重定向之类的扩展 `Shell` 语法（尽管 `shell` 变量始终起到了作用）。
如果您的命令需要特定于 `shell` 的语法，请改用 `shell` 模块。

到目前为止，我们所有的示例都使用了默认的“命令”模块。
要使用其他模块，请传递 `-m` 作为模块名称。
例如，使用 `shell` 模块：

```bash
$ ansible raleigh -m shell -a 'echo $TERM'
```

当使用 `Ansible ad hoc CLI`（而不是 `Playbook` ）运行任何命令时，请特别注意 `shell` 引用规则，因此本地 `shell` 会保留变量并将其传递给 `Ansible` 。
例如，在上面的示例中使用双引号而不是单引号的话，这会导致计算你所在的案例的变量。


#### 管理文件

临时任务可以利用 `Ansible` 和 `SCP` 的功能将许多文件并行传输到多台计算机。
要将文件直接传输到 `[atlanta]` 组中的所有服务器，请执行以下操作：

```bash
$ ansible atlanta -m copy -a "src=/etc/hosts dest=/tmp/hosts"
```
如果您打算重复这样的任务，请在剧本中使用模板模块。
文件模块允许更改文件的所有权和权限。
这些相同的选项也可以直接传递给复制模块：

```bash
$ ansible webservers -m file -a "dest=/srv/foo/a.txt mode=600"
$ ansible webservers -m file -a "dest=/srv/foo/b.txt mode=600 owner=mdehaan group=mdehaan"
```

文件模块还可以创建目录，类似于 `mkdir -p `：


```bash
$ ansible webservers -m file -a "dest=/path/to/c mode=755 owner=mdehaan group=mdehaan state=directory"
```
以及（递归）删除目录和删除文件：

```bash
$ ansible webservers -m file -a "dest=/path/to/c state=absent"
```

####  管理包

您还可以使用临时任务通过软件包管理模块（例如 `yum` ）在受管节点上安装，更新或删除软件包。
要确保安装软件包而不更新软件包：

```bash
$ ansible webservers -m yum -a "name=acme state=present"

```

要确保安装了特定版本的软件包：

```bash
$ ansible webservers -m yum -a "name=acme-1.5 state=present"
```

要确保安装了最新版本的软件包:

```bash
$ ansible webservers -m yum -a "name=acme state=latest"

```
确保移除软件包：

```bash
$ ansible webservers -m yum -a "name=acme state=absent"
```

`Ansible` 具有用于在许多平台下管理软件包的模块。
如果没有用于软件包管理器的模块，则可以使用命令模块安装软件包或为软件包管理器创建模块。

#### 管理用户和组

您可以使用临时任务在受控节点上创建，管理和删除用户帐户：

```bash
$ ansible all -m user -a "name=foo password=<crypted password here>"

$ ansible all -m user -a "name=foo state=absent"
```

####  管理服务


确保在所有 `Web` 服务器上启动了服务：

```bash
$ ansible webservers -m service -a "name=httpd state=started"
```

或者，在所有Web服务器上重新启动服务：

```bash
$ ansible webservers -m service -a "name=httpd state=restarted"
```
确保服务已停止：

```bash
$ ansible webservers -m service -a "name=httpd state=stopped"
```

#### 收集事实

事实代表发现的有关系统的变量。
您可以使用事实来实现任务的有条件执行，也可以仅获取有关系统的临时信息。
要查看所有事实：

```bash
$ ansible all -m setup

```

您也可以过滤此输出以仅显示某些事实，有关详细信息，请参阅[安装](https://docs.ansible.com/ansible/2.9/modules/setup_module.html#setup-module)模块文档。



## 使用命令行工具

大多数用户都熟悉 `ansible` 和 `ansible-playbook` ，但这些并不是 `Ansible` 提供的唯一实用程序。
以下是 `Ansible` 实用程序的完整列表。
每个页面均包含对该实用程序的描述以及支持的参数列表。

### ansible

针对一组宿主定义并运行单个任务“剧本”

大纲:

```bash
usage: ansible [-h] [--version] [-v] [-b] [--become-method BECOME_METHOD]
            [--become-user BECOME_USER] [-K] [-i INVENTORY] [--list-hosts]
            [-l SUBSET] [-P POLL_INTERVAL] [-B SECONDS] [-o] [-t TREE] [-k]
            [--private-key PRIVATE_KEY_FILE] [-u REMOTE_USER]
            [-c CONNECTION] [-T TIMEOUT]
            [--ssh-common-args SSH_COMMON_ARGS]
            [--sftp-extra-args SFTP_EXTRA_ARGS]
            [--scp-extra-args SCP_EXTRA_ARGS]
            [--ssh-extra-args SSH_EXTRA_ARGS] [-C] [--syntax-check] [-D]
            [-e EXTRA_VARS] [--vault-id VAULT_IDS]
            [--ask-vault-pass | --vault-password-file VAULT_PASSWORD_FILES]
            [-f FORKS] [-M MODULE_PATH] [--playbook-dir BASEDIR]
            [-a MODULE_ARGS] [-m MODULE_NAME]
            pattern

```
#### ansible 的描述： 

是用于执行“远程操作”的超简单工具/框架/ API。
此命令允许您针对一组宿主定义和运行单个任务“剧本”

#### 公共参数：

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 要求提供保险库密码  |
| --become-method <BECOME_METHOD>  | 要使用的特权升级方法(default=%(default)s)，请使用 `ansible-doc -t` 成为 `-l `列出有效的选择。  |
| --become-user <BECOME_USER>  | 以该用户身份运行操作（默认= root）  |
| --list-hosts  | 输出匹配宿主列表；不执行其他任何操作  |
| --playbook-dir <BASEDIR>  | 由于此工具不使用剧本，因此可以将其用作替代剧本目录，从而为许多功能设置相对路径，包括 `role/group_vars/` 等。  |
| --private-key <PRIVATE_KEY_FILE>, --key-file <PRIVATE_KEY_FILE>  | 使用此文件来验证连接  |
| --scp-extra-args <SCP_EXTRA_ARGS>  | 指定额外的参数以仅传递给 `scp`（例如 `-l` ）  |
| --ssh-common-args <SSH_COMMON_ARGS>  | 指定要传递给 `sftp` / `scp` / `ssh` 的通用参数（例如 `ProxyCommand` ）  |
| --ssh-extra-args <SSH_EXTRA_ARGS>  | 指定额外的参数以仅传递给ssh（例如-R）  |
| --syntax-check  | 在剧本上执行语法检查，但不执行  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置，然后退出  |
| -B <SECONDS>, --background <SECONDS>  | 异步运行，在X秒后失败（默认值= N/A）  |
| -C, --check  | 不进行任何更改；相反地，其会尝试预测可能发生的某些变化  |
| -D, --diff  | 更改（小的）文件和模板时，请显示这些文件中的差异；与 `–check` 一起使用效果很好  |
| -K, --ask-become-pass  | 索取提权密码  |
| -M, --module-path  | 将冒号分隔的路径添加到模块库（默认= `~/.ansible/plugins/modules:/usr/share/ansible/plugins/modules` ）  |
| -P <POLL_INTERVAL>, --poll <POLL_INTERVAL>  | 如果使用 `-B` ，则设置轮询间隔（默认值= 15）  |
| -T <TIMEOUT>, --timeout <TIMEOUT>  | 覆盖连接超时（以秒为单位）（默认为10）  |
| -a <MODULE_ARGS>, --args <MODULE_ARGS>  | 模块参数  |
| -b, --become  | 使用变为运行操作（不意味提示输入密码）  |
| -c <CONNECTION>, --connection <CONNECTION>  | 要使用的连接类型（默认= smart）  |
| -e, --extra-vars  | 如果文件名以 `@` 开头，则将其他变量设置为 `key= alue `或 `YAML/JSON`  |
| -f <FORKS>, --forks <FORKS>   |  指定要使用的并行进程数（默认= 5）   |
| -h, --help  |  显示此帮助消息并退出   |
| -i, --inventory, --inventory-file   |  指定清单宿主路径或逗号分隔的主机列表。 –不推荐使用清单文件   |
| -k, --ask-pass   |  询问连接密码   |
| -l <SUBSET>, --limit <SUBSET>  |  将所选宿主进一步限制为其他模式   |
| -m <MODULE_NAME>, --module-name <MODULE_NAME>  |  要执行的模块名称（默认=命令）   |
| -o, --one-line   | 浓缩输出  |
| -t <TREE>, --tree <TREE>   |  日志输出到该目录   |
| -u <REMOTE_USER>, --user <REMOTE_USER>   |  以该用户身份连接（默认=无）   |
| -v, --verbose   | 详细模式（ `-vvv` 用于更多，`-vvvv` 用于启用连接调试）    |
|    |     |

#### 环境：

可以指定以下环境变量。 

`ANSIBLE_CONFIG` –覆盖默认的 `ansible` 配置文件 

`ansible.cfg` 中的大多数选项都可以使用

ansible.cfg文件中的大多数选项都可以使用更多选项


#### 文件：

`/etc/ansible/ansible.cfg` –配置文件，
如果存在的话使用 `~/.ansible.cfg` –用户配置文件，覆盖默认的配置（如果存在）


### ansible-doc

插件文档工具

#### 大纲

```bash
usage: ansible-doc [-h] [--version] [-v] [-M MODULE_PATH]
                [--playbook-dir BASEDIR]
                [-t {become,cache,callback,cliconf,connection,httpapi,inventory,lookup,netconf,shell,module,strategy,vars}]
                [-j] [-F | -l | -s | --metadata-dump]
                [plugin [plugin ...]]
```
#### 描述

显示有关 `Ansible` 库中安装的模块的信息。
它显示了简短的插件清单及其简短描述，提供了其 `文档` 字符串的打印输出，并且可以创建一个简短的“代码片段”，可以粘贴到剧本中

#### 公共参数

| 参数  | 描述  |
| ------------ | ------------ |
| --metadata-dump  | 对于内部测试，仅转储所有插件的 `json` 元数据。  |
| --playbook-dir <BASEDIR>  | 由于此工具不使用剧本，因此可以将其用作替代剧本目录，从而为许多功能设置相对路径，包括 `role/group_vars/` 等。  |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置然后退出  |
| -F, --list_files  | 显示插件名称及其源文件，但不提供摘要（表示 `–list` ）  |
| -M, --module-path  | 将冒号分隔的路径添加到模块库（默认：`~/.ansible/plugins/modules:/usr/share/ansible/plugins/modules`）  |
| -h, --help  | 显示此帮助消息并退出  |
| -j, --json  | 将输出更改为 `json` 格式。  |
| -s, --snippet  | 显示指定插件的剧本摘要  |
| -t <TYPE>, --type <TYPE>  | 选择哪种插件类型（默认为 'module'）。可用的插件类型包括：（`become`，`cache`，'callback'，'cliconf'，'connection'，' httpapi'，'inventory'，'find'，'netconf'， 'shell'，'module'， strategy，'vars'）  |
| -v, --verbose  | 详细模式（ `-vvv` 用于更多，`-vvvv` 用于启用连接调试）  |
|   |   |


### ansible-galaxy

执行各种与角色和集合相关的操作

#### 大纲

```bash
usage: ansible-galaxy [-h] [--version] [-v] TYPE ...
```

#### 公共参数

| 参数  | 描述  |
| ------------ | ------------ |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置和退出  |
| -h, --help  | 显示此帮助消息并退出  |
| -v, --verbose  | 详细模式（ `-vvv ` 用于更多，`-vvvv` 用于启用连接调试）  |


#### 操作

##### 集合: `collection`

在 `Ansible Galaxy` 系列上执行操作。
必须结合下面列出的其他操作（如 `init` / `install` ）。

###### 集合初始化：`collection init`

创建符合Galaxy元数据格式的角色或集合的框架。
需要角色或集合名称。
集合名称必须采用以下格式

```
<namespace>.<collection>
```

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --collection-skeleton <COLLECTION_SKELETON>  | 新集合应基于的集合框架的路径。  |
| --init-path <INIT_PATH>  | 将在其中创建骨架集合的路径。默认值为当前工作目录。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -f, --force  | 强制覆盖现有角色或集合  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |


###### 构建集合：`collection build`

构建一个 `Ansible Galaxy` 集合工件，该工件可以存储在中央存储库（如 `Ansible Galaxy` ）中。
默认情况下，此命令从当前工作目录构建。
您可以选择传入集合输入路径（ `galaxy.yml` 所在位置）

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | Ansible Galaxy API密钥  |
| --output-path  | 集合建立的路径。默认值为当前工作目录。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -f, --force  | 强制覆盖现有角色或集合  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器网址  |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |

###### 安装集合： `collection install`

安装一个或多个角色（ `ansible-galaxy role install`），或安装一个或多个集合（ `ansible-galaxy collection install` ）。
您可以传递一个列表（角色或集合）或使用下面列出的文件选项（这些选项是互斥的）。
如果您传递一个列表，则它可以是名称（将通过 `galaxy API` 和 `github` 下载），也可以是本地 `tar` 存档文件。

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | Ansible Galaxy API密钥  |
| --force-with-deps  | 强制覆盖现有集合及其依赖项。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -f, --force  | 强制覆盖现有角色或集合  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器网址  |
| -i, --ignore-errors  | 忽略安装期间的错误，并继续安装下一个指定的集合。然而并不会忽略依赖项冲突错误。  |
| -n, --no-deps  | 不要下载列为依赖项的集合。  |
| -p <COLLECTIONS_PATH>, --collections-path <COLLECTIONS_PATH>  | 包含您的集合的目录的路径。  |
| -r <REQUIREMENTS>, --requirements-file <REQUIREMENTS>  | 包含要安装的集合列表的文件。  |
|   |   |


##### 角色 `role`

在 `Ansible Galaxy` 角色上执行操作。
必须与下面列出的其他操作（如 `delete/install/init` ）结合使用。

###### 初始化角色:  role init 

创建符合 `Galaxy` 元数据格式的角色或集合的框架。
需要角色或集合名称。
集合名称的格式必须是 `<namespace>.<collection>`

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --init-path <INIT_PATH>  | 将在其中创建骨架集合的路径。默认值为当前工作目录。  |
| --offline  | 创建角色时不要查询 API  |
| --role-skeleton <ROLE_SKELETON>  | 新角色应基于的角色骨架的路径。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -f, --force  | 强制覆盖现有角色或集合  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |


###### 删除角色列表： `role remove`

从本地系统中删除作为参数传递的角色列表。


| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -p, --roles-path  | 包含您的角色的目录的路径。默认是通过 `DEFAULT_ROLES_PATH` 配置的第一个可写文件 `~/.ansible/roles:/usr/share/ansible/roles:/etc/ansible/roles` |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 删除单个角色： `role delete`

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 列出角色列表：  `role list`


列出安装在本地系统上的角色，或与作为参数传递的单个角色匹配。

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -p, --roles-path  | 包含您的角色的目录的路径。默认是通过 `DEFAULT_ROLES_PATH` 配置的第一个可写文件 `~/.ansible/roles:/usr/share/ansible/roles:/etc/ansible/roles` |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 搜索角色: role search

在 `Ansible Galaxy` 服务器上搜索角色

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --author <AUTHOR>  | GitHub用户名  |
| --galaxy-tags <GALAXY_TAGS>  | 要过滤的标签列表  |
| --platforms <PLATFORMS>  | 要过滤的系统平台列表  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 导入角色：`role import`

用于将角色导入Ansible Galaxy

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | Ansible Galaxy API密钥，可在 https://galaxy.ansible.com/me/preferences 中找到。您还可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --branch <REFERENCE>  | 要导入的分支的名称。默认为存储库的默认分支（通常是 `master` 分支）  |
| --no-wait  | 不等待导入结果。  |
| --role-name <ROLE_NAME>  | 角色应具有的名称（如果与仓库名称不同）  |
| --status  | 检查给定 `github_user/github_repo` 的最新导入请求的状态。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 集成角色 `role setup`

从 `Github` 或 `Travis` 上 集成  `Ansible Galaxy` 角色的一体化

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | Ansible Galaxy API密钥，可在https://galaxy.ansible.com/me/preferences中找到。您还可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --list  | 列出所有集成。   |
| --remove <REMOVE_ID>  | 删除与提供的ID值匹配的集成。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -p, --roles-path  | 包含您的角色的目录的路径。默认是通过 `DEFAULT_ROLES_PATH` 配置的第一个可写文件 `~/.ansible/roles:/usr/share/ansible/roles:/etc/ansible/roles` |


 
###### 角色信息： role info

打印出有关已安装角色的详细信息以及可从 `galaxy API` 获得的信息。

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | [文档](https://galaxy.ansible.com/me/preferences) 您也可以为 `GALAXY_SERVER_LIST` 条目设置令牌。  |
| --offline  | 创建角色时不要查询 API  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -p, --roles-path  | 包含您的角色的目录的路径。默认是通过 `DEFAULT_ROLES_PATH` 配置的第一个可写文件 `~/.ansible/roles:/usr/share/ansible/roles:/etc/ansible/roles` |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器URL  |

###### 安装角色： role install 

安装一个或多个角色（ansible-galaxy role install ），或安装一个或多个集合（ansible-galaxy collection install）。
您可以传递列表（角色或集合）或使用下面列出的文件选项（这些选项是互斥的）。
如果您传递列表，则它可以是名称（将通过galaxy API和github下载），也可以是本地tar存档文件。

| 参数  | 描述  |
| ------------ | ------------ |
| --api-key <API_KEY>  | Ansible Galaxy API密钥  |
| --force-with-deps  |  强制覆盖现有角色及其依赖项。  |
| -c, --ignore-certs  | 忽略SSL证书验证错误。  |
| -f, --force  | 强制覆盖现有角色或集合  |
| -s <API_SERVER>, --server <API_SERVER>  | Galaxy API服务器网址  |
| -i, --ignore-errors  | 忽略错误并继续下一个指定的角色。  |
| -n, --no-deps  | 不要下载列为依赖项的角色。  |
| -p, --roles-path  | 包含您的角色的目录的路径。默认是通过 `DEFAULT_ROLES_PATH` 配置的第一个可写文件 `~/.ansible/roles:/usr/share/ansible/roles:/etc/ansible/roles` |
| -r <ROLE_FILE>, --role-file <ROLE_FILE> | 包含要安装的角色列表的文件。  |


### ansible-inventory

#### 大纲

```
usage: ansible-inventory [-h] [--version] [-v] [-i INVENTORY]
                      [--vault-id VAULT_IDS]
                      [--ask-vault-pass | --vault-password-file VAULT_PASSWORD_FILES]
                      [--playbook-dir BASEDIR] [--list] [--host HOST]
                      [--graph] [-y] [--toml] [--vars] [--export]
                      [--output OUTPUT_FILE]
                      [host|group]
```

#### 描述

用于显示或转储 `Ansible` 看到的已配置清单的常用选项

#### 公共选项

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 要求提供保险库密码  |
| --export  | 执行 `–list` 时，以针对导出进行优化的方式呈现，而不是Ansible处理方式的准确表示  |
| --graph  | 创建清单图，如果提供模式，则必须是有效的组名  |
| --host <HOST>  | 输出指定的宿主信息，用作清单脚本  |
| --list  | 输出特定的宿主信息，用作清单脚本  |
| --list-hosts  |   |
| --output <OUTPUT_FILE>  | 执行`–list` 时，将清单发送到文件而不是发送到屏幕  |
| --playbook-dir <BASEDIR>  | 由于此工具不使用剧本，因此可以将其用作替代剧本目录，从而为许多功能（包括 `role/group_vars/` 等）设置相对路径。  |
| --toml  | 使用 TOML 格式而不是默认 JSON ，对 `–graph` 忽略  |
| --vars | 将变量添加到图形显示，除非与 `–graph` 一起使用，否则将被忽略  |  
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置然后退出  |
|  -h, --help  | 显示此帮助消息并退出   |
| -i, --inventory, --inventory-file  | 指定清单宿主路径或逗号分隔的主机列表。–不推荐使用 --inventory-file |
| -v, --verbose  | 详细模式（ `-vvv` 用于查看更多，`-vvvv` 用于启用连接调试）  |
| -y, --yaml  | 使用 `YAML` 格式而不是默认 `JSON` ，对于 `–graph` 会被忽略  |
|   |   |
|   |   |


### ansible-playbook

#### 大纲

```bash
usage: ansible-playbook [-h] [--version] [-v] [-k]
                     [--private-key PRIVATE_KEY_FILE] [-u REMOTE_USER]
                     [-c CONNECTION] [-T TIMEOUT]
                     [--ssh-common-args SSH_COMMON_ARGS]
                     [--sftp-extra-args SFTP_EXTRA_ARGS]
                     [--scp-extra-args SCP_EXTRA_ARGS]
                     [--ssh-extra-args SSH_EXTRA_ARGS] [--force-handlers]
                     [--flush-cache] [-b] [--become-method BECOME_METHOD]
                     [--become-user BECOME_USER] [-K] [-t TAGS]
                     [--skip-tags SKIP_TAGS] [-C] [--syntax-check] [-D]
                     [-i INVENTORY] [--list-hosts] [-l SUBSET]
                     [-e EXTRA_VARS] [--vault-id VAULT_IDS]
                     [--ask-vault-pass | --vault-password-file VAULT_PASSWORD_FILES]
                     [-f FORKS] [-M MODULE_PATH] [--list-tasks]
                     [--list-tags] [--step] [--start-at-task START_AT_TASK]
                     playbook [playbook ...]
```

#### 描述

运行 `Ansible` 剧本的工具，`Ansible` 剧本是一个配置和多节点部署系统。
有关更多信息，请参见项目主页（https://docs.ansible.com）。


#### 公共选项

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 要求提供保险库密码  |
| --become-method <BECOME_METHOD>  | 要使用的特权升级方法 `(default=%(default)s)` ，请使用 `ansible-doc -t become -l` 列出有效的选择。  |
| --become-user <BECOME_USER>  | 以该用户身份运行操作（默认= root）  |
| --flush-cache  | 清除清单中每个宿主的事实缓存  |
| --force-handlers  | 即使任务失败也运行处理程序  |
| --list-hosts  | 输出匹配宿主列表 .不执行其他任何操作  |
| --list-tags  | 列出所有可用标签  |
| --list-tasks  | 列出将要执行的所有任务  |
| --private-key <PRIVATE_KEY_FILE>, --key-file <PRIVATE_KEY_FILE>   | 使用此文件来验证连接  |
| --scp-extra-args <SCP_EXTRA_ARGS>  | 指定额外的参数以仅传递给scp（例如-l）  |
| --sftp-extra-args <SFTP_EXTRA_ARGS>  | 指定额外的参数以仅传递给sftp（例如-f，-l）  |
| --skip-tags  | 仅运行标签与这些值不匹配的剧本和任务  |
| --ssh-common-args <SSH_COMMON_ARGS>  | 指定要传递给 `sftp/scp/ssh` 的通用参数（例如 `ProxyCommand` ）  |
| --ssh-extra-args <SSH_EXTRA_ARGS>  | 指定额外的参数以仅传递给ssh（例如-R）  |
| --start-at-task <START_AT_TASK>  | 在与此名称匹配的任务处启动剧本  |
| --step  | 一步一步：在运行之前确认每个任务  |
| --syntax-check  | 在剧本上执行语法检查，但不执行  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置然后退出  |
| -C, --check  | 不进行任何更改；相反，尝试预测可能发生的某些变化  |
| -D, --diff  | 更改（小的）文件和模板时，显示这些文件中的差异；与 `–check`一起使用效果很好  |
| -K, --ask-become-pass  | 要求特权密码  |
| -M, --module-path  | 将冒号分隔的路径添加到模块库(默认 ： `~/.ansible/plugins/modules:/usr/share/ansible/plugins/modules`)  |
| -T <TIMEOUT>, --timeout <TIMEOUT>   | 覆盖连接超时（以秒为单位）（默认为10）  |
| -b, --become  | 使用become进行操作  |
| -c <CONNECTION>, --connection <CONNECTION>  | 要使用的连接类型（默认=smart）  |
| -e, --extra-vars  | 如果文件名以@开头，则将其他变量设置为key=value或YAML/JSON  |
| -f <FORKS>, --forks <FORKS>  | 指定要使用的并行进程数（默认= 5）  |
| -h, --help  | 显示此帮助消息并退出  |
| -i, --inventory, --inventory-file  | 指定清单宿主路径或逗号分隔的主机列表。 –不推荐使用 --inventory-file  |
| -k, --ask-pass  | 询问连接密码  |
| -l <SUBSET>, --limit <SUBSET>  | 将所选宿主进一步限制为其他模式  |
| -t, --tags  | 只运行带有这些值标记的剧本和任务  |
| -u <REMOTE_USER>, --user <REMOTE_USER>  | 以该用户身份连接（默认=无）  |
| -v, --verbose  | 详细模式（-vvv用于更多，-vvvv用于启用连接调试）  |
|   |   |
|   |   |
|   |   |


### ansible-vault

`Ansible` 数据文件的加密/解密实用程序

#### 大纲

```
usage: ansible-vault [-h] [--version] [-v]
                  {create,decrypt,edit,view,encrypt,encrypt_string,rekey}
                  ...
```

#### 描述

可以加密Ansible使用的任何结构化数据文件。
这可能包括 `group_vars/ ` 或 `group_vars/ ` 清单变量，由 `include_vars` 或 `vars_files` 加载的变量，或通过 `-e @file.yml` 或 `-e @file.json` 在 `ansible-playbook` 命令行上传递的变量文件。

角色变量和默认值也包括在内！

由于 `Ansible` 任务，处理程序,其他对象，都是数据，因此也可以使用 `Vault` 对其进行加密。
如果您不想公开正在使用的变量，则可以将单个任务文件完全加密

#### 公共选项

| 参数  | 描述  |
| ------------ | ------------ |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置之后退出  |
| -h, --help  | 显示此帮助消息并退出  |
| -v, --verbose  | 详细模式（-vvv用于更多，-vvvv用于启用连接调试）  |


#### 操作

##### create

在编辑器中创建并打开文件，该文件在关闭时将使用提供的文件库密钥进行加密

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索取密码库密码  |
| --encrypt-vault-id <ENCRYPT_VAULT_ID>  | 用于加密的库ID（如果提供的库ID大于ID，则为必填项）  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 密码库密码文件  |

##### decrypt

使用提供的密码库密钥解密提供的文件

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库库密码  |
| --output <OUTPUT_FILE>  | 输出文件名进行加密或解密；使用-用于标准输出  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |

##### edit

在编辑器中打开并解密现有的已存储文件，关闭后将再次对其进行加密

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库库密码  |
| --encrypt-vault-id <ENCRYPT_VAULT_ID>  | 用于加密的库ID（如果##提供的库ID大于ID，则为必填项）  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |

##### view

用 `Vault` 密钥调用呼叫器打开、解密、查看现有的 `Vault` 文件

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库库密码  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |




##### encrypt

使用提供的保管库密钥加密提供的文件


| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库密码  |
| --encrypt-vault-id <ENCRYPT_VAULT_ID>  | 用于加密的库ID（如果##提供的库ID大于ID，则为必填项）  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --output <OUTPUT_FILE>  | 输出文件名进行加密或解密；使用-用于标准输出  |


##### encrypt_string

使用提供的密码库密钥加密提供的字符串

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库密码  |
| --encrypt-vault-id <ENCRYPT_VAULT_ID>  | 用于加密的库ID（如果##提供的库ID大于ID，则为必填项）  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --output <OUTPUT_FILE>  | 输出文件名进行加密或解密；使用-用于标准输出  |
| --stdin-name <ENCRYPT_STRING_STDIN_NAME>  | 指定标准输入的变量名  |
| -n, --name  | 指定变量名称  |
| -p, --prompt  | 提示要加密的字符串  |

##### rekey

使用新的密钥重新加密已存储文件，需要先前的密钥

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 索要保险库密码  |
| --encrypt-vault-id <ENCRYPT_VAULT_ID>  | 用于加密的库ID（如果##提供的库ID大于ID，则为必填项）  |
| --new-vault-id <NEW_VAULT_ID>  | 用于更新密钥的新密码库身份  |
| --new-vault-password-file <NEW_VAULT_PASSWORD_FILE>  | 新的保险库密码文件以进行密钥更新  |
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
|   |   |
|   |   |
|   |   |
|   |   |


## 使用剧本

剧本是 `Ansible` 的配置，部署和编排语言。
它们可以描述您希望远程系统执行的策略，或一般 `IT` 流程中的一组步骤。

如果 `Ansible` 模块是您工作站中的工具，则剧本是您的说明手册，宿主清单是您的原材料。

从根上讲，剧本可用于管理远程服务器的配置和部署。
从更高的角度上来说，他们可以对涉及滚动更新的多层部署进行排序，并可以将操作委派给其他宿主，并与监视服务器和负载平衡器进行交互。


尽管这里有很多信息，但无需一次学习所有内容。
您可以从小处着手，并在需要时随时间使用更多功能。


剧本被设计为易于阅读的，并以基于文本的语言开发。
有多种方法来组织剧本及其包含的文件。

### 关于剧本

与临时任务执行模式相比，剧本是使用 `ansible` 的完全不同的方式，并且功能特别强大。

简而言之，剧本是一种非常简单的配置管理和多机部署系统的基础，与现有的系统不同，它非常适合于部署复杂的应用程序。

### 剧本语言示例

常规手册以YAML格式表示（请参见[YAML](https://xiaomiwujiecao.github.io/KongFuOfArchitect/#/./part3/yaml/README)语法），并且具有最少的语法，这有意地尝试不是编程语言或脚本，而是配置或过程的模型。

!> 一些编辑器具有附加组件，可以帮助您在剧本中编写简洁的 `YAML` 语法。
有关详细信息，请参见其他工具和程序。


每个剧本由一个列表中的一个或多个“剧本”组成。
剧本的目的是将一组宿主映射到一些定义明确的角色，这些角色以无障碍调用任务为代表。
从根本上讲，任务不过是对 `ansible` 模块的调用。

通过编写包含多个 ”戏” 的剧本，可以编排多机部署，在 `webservers` 组中的所有计算机上运行某些步骤，然后在数据库服务器组中运行某些步骤，然后在 `webservers` 组中返回更多命令，等等。 
。
“戏”或多或少是体育类比。
您可能会遇到很多影响系统做不同事情的事情。
好像您不是在定义一种特定的状态或模型，而是可以在不同的时间进行不同的戏。

首先，这是一本剧本，`verify-apache.yml` ，其中仅包含一部剧本：

```yml
---
- hosts: webservers
  vars:
    http_port: 80
    max_clients: 200
  remote_user: root
  tasks:
  - name: ensure apache is at the latest version
    yum:
      name: httpd
      state: latest
  - name: write the apache config file
    template:
      src: /srv/httpd.j2
      dest: /etc/httpd.conf
    notify:
    - restart apache
  - name: ensure apache is running
    service:
      name: httpd
      state: started
  handlers:
    - name: restart apache
      service:
        name: httpd
        state: restarted
```

剧本可以包含多个戏。
您可能有一本首先针对 `Web` 服务器，然后针对数据库服务器的剧本。
例如：

```yml

---
- hosts: webservers
  remote_user: root

  tasks:
  - name: ensure apache is at the latest version
    yum:
      name: httpd
      state: latest
  - name: write the apache config file
    template:
      src: /srv/httpd.j2
      dest: /etc/httpd.conf

- hosts: databases
  remote_user: root

  tasks:
  - name: ensure postgresql is at the latest version
    yum:
      name: postgresql
      state: latest
  - name: ensure that postgresql is started
    service:
      name: postgresql
      state: started

```
您可以使用此方法在您要定位的宿主组，登录到远程服务器的用户名，是否使用sudo等之间切换。
像任务一样，戏按照剧本中指定的顺序运行：从上到下。


下面，我们将详细介绍剧本语言的各种功能。

### 基础

#### 宿主和用户

对于剧本中的每场戏，您都可以选择基础结构中要定位的计算机以及要完成这些步骤（称为任务）的远程用户。

宿主行是一个或多个组或主机模式的列表，用冒号分隔
`remote_user` 只是用户帐户的名称：

```yml
---
- hosts: webservers
  remote_user: root

```

!> `remote_user` 参数以前称为 `user`。
在 `Ansible 1.4` 中将其重命名，以使其与用户模块（用于在远程系统上创建用户）更加区分开。

也可以为每个任务定义远程用户：

```yml
- hosts: webservers
  remote_user: root
  tasks:
    - name: test connection
      ping:
      remote_user: yourname
```
还支持以其他用户身份运行事物:

```yml
---
- hosts: webservers
  remote_user: yourname
  become: yes
```
在特定任务上而不是整场戏中,你可以使用关键字 `become`：

```yml
---
- hosts: webservers
  remote_user: yourname
  tasks:
    - service:
        name: nginx
        state: started
      become: yes
      become_method: sudo
```

您还可以以您的身份登录，然后成为不同于 `root` 用户的用户：


```yml
---
- hosts: webservers
  remote_user: yourname
  become: yes
  become_user: postgres
```

您还可以使用其他特权升级方法，例如 `su` ：

```yml
---
- hosts: webservers
  remote_user: yourname
  become: yes
  become_method: su
```


如果您需要为 `sudo` 指定密码，请使用 `--ask-become-pass` 或 `-K` 运行 `ansible-playbook` 。
如果您使用 `become` 来跑这场戏而该剧本似乎挂起了，则它可能停留在特权升级提示下，并且可以使用 `Control-C` 停止，从而允许您添加适当的密码来重新执行该剧本

!> 将 `root_user` 用作 `root` 以外的用户时，模块参数将简短地写入`/tmp` 中的随机临时文件中。
这些命令执行后立即删除。
仅当将特权从“ bob”更改为“ timmy”时，才会发生这种情况，而不是从“ bob”更改为“ root”时，或直接以“ bob”或“ root”身份登录时。
如果您担心此数据是短暂可读（但不可写）的，请避免使用 `set_user` 设置传输未加密的密码。
在其他情况下，不使用 `/tmp`，也不起作用。 
`Ansible` 还注意不要记录密码参数。


您还可以控制宿主的运行顺序。
默认值是遵循清单提供的顺序：

```yml
- hosts: all
  order: sorted
  gather_facts: False
  tasks:
    - debug:
        var: inventory_hostname
```

排序的可能情况为：


| 参数  | 描述  |
| ------------ | ------------ |
| inventory  | 默认值。顺序为是“以清单为准”  |
| reverse_inventory  | 显然，这是上面排序的逆排序法 |
| sorted  | 宿主按名称的字母顺序排列  |
| reverse_sorted  | 显然，这是上面排序的逆排序法  |
| shuffle  | 每次运行都会进行乱序处理  |


#### 任务列表

每个剧本都有一个任务列表。一般情况，他们都是按照顺序执行的，一次一个，在继续执行下一个任务之前，对所有与宿主模式匹配的机器进行测试。
重要的是要了解，在一出戏中，所有宿主都将获得相同的任务指令。
戏的目的是将宿主的选择映射到任务。

每个任务的目标是执行带有特定参数的模块。
变量可以在模块的参数中使用。
模块应该是幂等的，也就是说，按顺序运行模块多次应与仅运行一次模块具有相同的效果。
实现幂等的一种方法是让模块检查是否已达到其所需的最终状态，如果已经达到该状态，则不执行任何操作即可退出。
如果剧本使用的所有模块都是幂等的，则剧本本身很可能是幂等的，因此重新运行剧本应该是安全的。

`command` 和 `shell` 模块 通常会再次重新运行同一个命令，如果该命令是诸如 `chmod` 或 `setsebool` 等，则完全可以。尽管有一个 `create` 标志可用于使这些模块也成为幂等。
每个任务都应有一个名称: `name`，该名称包含在运行剧本的输出中。
这是人类可读的输出，因此提供每个任务步骤的良好描述很有用。
如果未提供名称，则输入到“ action”的字符串将用于输出。

可以使用旧版的声明方式： `action: module options`
但建议您使用更常规的: `module: options`
在整个文档中都使用此推荐格式，但是在某些剧本中可能会遇到较旧的格式。

这是基本任务的样子。
与大多数模块一样，服务模块采用 `key:value` 参数：

```yml
tasks:
  - name: make sure apache is running
    service:
      name: httpd
      state: started
```
`command` 和 `shell` 模块是仅有的一组参数，并且是不使用 `key:value`形式的仅有的模块。
这使它们像您期望的那样简单地工作：

```yml
tasks:
  - name: enable selinux
    command: /sbin/setenforce 1
```

`` `` 关心的是返回码 ，如果您有一个成功退出码不为0的命令，则可能需要这样做：

```yml
tasks:
  - name: run this command and ignore the result
    shell: /usr/bin/somecommand || /bin/true
```

或者 这样做： 

```yml
tasks:
  - name: run this command and ignore the result
    shell: /usr/bin/somecommand
    ignore_errors: True
```

如果操作行太长而令你不爽，则可以在空格处将其断开并缩进任何续行：

```yml
tasks:
  - name: Copy ansible inventory file to client
    copy: src=/etc/ansible/hosts dest=/etc/ansible/hosts
            owner=root group=root mode=0644
```

变量可以在操作行中使用。
假设您在 `vars` 部分中定义了一个名为 `vhost` 的变量，则可以执行以下操作：

```yml
tasks:
  - name: create a virtual host file for {{ vhost }}
    template:
      src: somefile.j2
      dest: /etc/httpd/conf.d/{{ vhost }}
```

这些相同的变量可在模板中使用，稍后我们将介绍。

### 操作速记 

`Ansible` 偏好酱紫列出的模块：

```yml
template:
    src: templates/foo.j2
    dest: /etc/foo.conf
```
Ansible的早期版本使用以下格式，该格式仍然有效：

```yml
action: template src=templates/foo.j2 dest=/etc/foo.conf
```

### 处理程序：更改时,运行操作

正如我们已经提到的，模块应该是幂等的，并且可以在远程系统上进行更改后进行中继。
剧本认识到这一点，并具有可用于响应变化的基本事件系统。

这些“通知”动作是在剧本中每个任务块的结尾处触发的，即使被多个不同的任务通知，也只会触发一次。
例如，多个资源可能指示 `apache` 需要重新启动，因为它们已经更改了配置文件，但是 `apache` 只会被退回一次以避免不必要的重新启动。
这是一个在文件内容更改时（但仅在文件更改时）重新启动两个服务的示例：

```yml
- name: template configuration file
  template:
    src: template.j2
    dest: /etc/foo.conf
  notify:
     - restart memcached
     - restart apache
```

任务的通知部分中列出的事物称为处理程序。
处理程序是任务的列表，实际上与常规任务没有什么不同，它们由全局唯一名称引用，并由通知者通知。
如果没有任何通知处理程序，它将不会运行。
无论有多少个任务通知处理程序，在特定任务中完成所有任务后，它将仅运行一次。

这是处理程序示例部分：

```yml
handlers:
    - name: restart memcached
      service:
        name: memcached
        state: restarted
    - name: restart apache
      service:
        name: apache
        state: restarted
```
您可能希望 `Ansible` 处理程序使用变量。
例如，如果服务名称因分发而略有不同，则您希望输出显示每台目标计算机的重新启动服务的确切名称。
避免将变量放在处理程序的名称中。
由于处理程序名称是早期的模板，因此 `Ansible` 可能没有可用于以下处理程序名称的值：

```yml
handlers:
# this handler name may cause your play to fail!
- name: restart "{{ web_service_name }}"
```
如果在处理程序名称中使用的变量不可用，则整场戏将失败。
在戏中更改该变量不会导致新创建处理程序。
取而代之的是将变量放在处理程序的任务参数中。
您可以使用 `include_vars` 这样加载值：

```yml
tasks:
  - name: Set host variables based on distribution
    include_vars: "{{ ansible_facts.distribution }}.yml"

handlers:
  - name: restart web service
    service:
      name: "{{ web_service_name | default('httpd') }}"
      state: restarted
```

从Ansible 2.2开始，处理程序还可以“侦听”通用主题，任务可以如下通知这些主题：

```yml
handlers:
    - name: restart memcached
      service:
        name: memcached
        state: restarted
      listen: "restart web services"
    - name: restart apache
      service:
        name: apache
        state: restarted
      listen: "restart web services"

tasks:
    - name: restart everything
      command: echo "this task will restart the web services"
      notify: "restart web services"
```
这种用法使触发多个处理程序变得更加容易。
它还使处理程序与其名称脱钩，从而使在剧本和角色之间共享处理程序变得更容易（尤其是在使用来自诸如Galaxy之类的共享源的第三方角色时）。

!> 

- 通知处理程序始终按照定义的顺序运行，而不是按notify-statement中列出的顺序运行。使用侦听器的处理程序也是如此。

- 处理程序名称和侦听主题位于全局命名空间中。

- 处理程序名称是可模板化的，而侦听主题则不是。

- 使用唯一的处理程序名称。如果您触发多个同名处理程序，则第一个处理程序将被覆盖。仅定义的最后一个将运行。

- 您无法通知在部署内包含定义的处理程序。从 `Ansible 2.1` 开始，这确实有效，但是 `include` 必须是静态的。

!>


角色将在后面介绍，但有必要指出：

在 `pre_tasks`，`task` 和 `post_tasks` 部分中通知的处理程序将在通知它们的部分末尾自动刷新，
在“角色”部分中通知的处理程序将在“任务”部分的末尾自动刷新，但在所有任务处理程序之前，
处理程序是作用域范围的，因此可以在定义它们的角色之外使用。
如果您想立即刷新所有处理程序命令，则可以执行以下操作：

```yml
tasks:
   - shell: some tasks go here
   - meta: flush_handlers
   - shell: some other tasks
```
在上面的示例中，任何到达队列的处理程序都将在到达 `meta` 语句时及早处理。
这是一个小众案例，但有时会派上用场。

### 执行一个剧本

```bash
ansible-playbook playbook.yml
```

### Ansible-Pull

如果您想反转Ansible的体系结构，以便节点检入到中心位置，而不必向其推送配置，则可以。

`ansible-pull` 是一个小脚本，它将签出git源中的配置指令，然后针对该内容运行 `ansible-playbook`。

假设您对检出位置进行负载平衡，则 `ansible-pull` 本质上可以无限扩展。

运行 `ansible-pull --help` 了解详细信息。


### 整理剧本

在执行之前，您可以使用 `ansible-lint` 对您的剧本进行详细检查。

例如，如果您在本节前面介绍的 `verify-apache.yml` 剧本上运行 `ansible-lint` ，则会得到以下结果：

```bash
$ ansible-lint verify-apache.yml
[403] Package installs should not use latest
verify-apache.yml:8
Task/Handler: ensure apache is at the latest version
```
` ansible-lint` 默认规则页面描述了每个错误。
对于[403]，建议的解决方法是将 `state: latest` 更改为 `state: present` 于剧本中。

### 其他剧本验证选项

以下是您应考虑的其他一些事项：

要检查剧本的语法，请使用带有 `--syntax-check`  标志的 `ansible-playbook` 。
这将通过解析器运行剧本文件，以确保其包含的文件，角色等没有语法问题。

在剧本执行的底部查看有关目标节点及其执行方式的摘要。
常规故障和致命的 `unreachable` 的通信尝试在计数中保持分开。

如果您想查看成功模块的详细输出以及失败模块的详细输出，请使用 `--verbose` 标志。
在Ansible 0.5及更高版本中可用。

要在运行剧本之前查看哪些宿主会受到剧本的影响，可以执行以下操作：


```bash
ansible-playbook playbook.yml --list-hosts
```

### 创建可复用的剧本

虽然可以在一个非常大的文件中编写剧本（并且您可能会开始以这种方式学习剧本），但最终您将需要重用文件并开始整理内容。
在Ansible中，有三种方法可以做到这一点：`include`,`imports` 和 `roles`。

包含(`include`)和导入(`import`)（在Ansible 2.4版中添加）允许用户将大型剧本拆分成较小的文件，这些文件可以在多个父级剧本中使用，甚至可以在同一本 `剧本`中多次使用。

角色不仅可以将任务打包在一起，还可以包括变量，处理程序，甚至模块和其他插件。
与包含和导入不同，角色也可以通过 `Ansible Galaxy` 上传和共享。

#### 动与静

Ansible具有可重复使用内容的两种操作模式：动态和静态。

在Ansible 2.0中，引入了动态包含的概念。
由于以这种方式使所有包含动态化存在一些限制，因此Ansible 2.1中引入了强制包含静态的能力。
由于 `include` 任务变得过载以包含静态和动态语法，并且因为 `include` 的默认行为可能会基于 `Task` 上设置的其他选项而改变，因此 `Ansible 2.4` 引入了`include`  与 ` import `的概念。

如果使用任何`include*`任务（`include_tasks`，`include_role`等），它将是动态的。
如果您使用任何 `import *` 任务（`import_playbook`，`import_tasks` 等），它将是静态的。

纯 `include`任务（用于任务文件和 `Playbook` 级包含）仍然可用，但是现在认为已弃用

#### 动静分别

这两种操作模式非常简单：

- 动态包含在运行时在遇到该任务时进行处理。
- `Ansible` 在 `剧本` 解析期间会预处理所有静态导入。

当涉及Ansible任务选项时，例如 `tags` 和条件语句（`when:`）：

- 对于动态包含，任务选项将仅在评估动态任务时应用于动态任务，而不会复制到子任务。
- 对于静态导入，父任务选项将复制其所包含的内容到所有子任务。

!> 角色是一种特殊情况。
在Ansible 2.3之前，角色总是通过特殊角色静态包含在角色中：给定基本的选项，并且总是在执行任何其他播放任务之前首先执行（除非使用 `pre_tasks`）。
仍然可以通过这种方式使用角色，但是，Ansible 2.3引入了 `include_role` 选项，以允许与其他任务一起内联执行角色


#### 包含与导入之间的权衡与坑

使用 `include *` 与 `import *` 具有一些优点以及用户在选择使用它们时应考虑的一些折衷：
使用 `include *` 语句的主要优点是循环。
当循环与包含一起使用时，所包含的任务或角色将对循环中的每个项目执行一次。

与 `import *` 语句相比，使用 `include *` 确实有一些限制：

- 仅存在于动态包含中的标签不会显示在 `--list-tags` 输出中。
- 仅存在于动态包含中的任务不会显示在 `--list-tasks` 输出中。
- 您不能使用 `notify` 来触发来自动态包含内部的处理程序名称（请参见下面的注释）。
- 您不能使用 `--start-at-task` 在动态包含中的某个任务上开始执行。

与动态包含相比，使用 `import *` 也可能有一些限制：

- 如上所述，循环根本不能与导入一起使用。
- 将变量用作目标文件或角色名称时，无法使用清单资源（宿主/组变量等）中的变量。
- 使用 `import *` 的处理程序通过名称通知时不会触发，因为导入会使用导入的任务列表覆盖处理程序的命名任务。

!> 关于将通知用于动态任务：仍然可以触发动态包含本身，这将导致包含中的所有任务都运行。

### 使用变量

虽然存在自动化可以使事情变得可重复，但所有系统并不完全相同。
有些可能需要与其他配置稍有不同的配置。
在某些情况下，观察到的一个系统的行为或状态可能会影响您配置其他系统的方式。
例如，您可能需要找出一个系统的 `IP` 地址，并将其用作另一个系统上的配置值。

`Ansible` 使用变量来帮助处理系统之间的差异。
要了解变量，您还需要阅读条件和循环。
诸如 `group_by` 模块和 `when` 条件等有用的东西也可以与变量一起使用，并帮助管理系统之间的差异。

#### 创建变量名

在开始使用变量之前，重要的是要知道什么是有效的变量名。
变量名称应为字母，数字和下划线。
变量应始终以字母开头。

好的变量：

foo_port 

foo5 

坏的变量：

foo-port, foo port, foo.port

12

`YAML` 还支持将键映射到值的字典。
例如：

```yml
foo:
  field1: one
  field2: two

```

然后，您可以使用方括号或点号来引用字典中的特定字段：

```
foo['field1']
foo.field1
```

这些都将引用相同的值（"one"）。
但是，如果选择使用点表示法，请注意某些键可能会引起问题，因为它们与 `python` 词典的属性和方法冲突。


如果您使用以两个下划线开头和结尾的键（这些键在 `python` 中保留了特殊含义）或为任何已知的公共属性，则应使用方括号符号而不是点符号。

| 参数  | 描述  |
| ------------ | ------------ |
| add | -- |  
|  append | -- |  
|  as_integer_ratio | -- |  
|  bit_length | -- |  
|  capitalize | -- |  
|  center | -- |  
|  clear | -- |  
|  conjugate | -- |  
|  copy | -- |  
|  count | -- |  
|  decode | -- |  
|  denominator | -- |  
|  difference | -- |  
|  difference_update | -- |  
|  discard | -- |  
|  encode | -- |  
|  endswith | -- |  
|  expandtabs | -- |  
|  extend | -- |  
|  find | -- |  
|  format | -- |  
|  fromhex | -- |  
|  fromkeys | -- |  
|  get | -- |  
|  has_key | -- |  
|  hex | -- |  
|  imag | -- |  
|  index | -- |  
|  insert | -- |  
|  intersection | -- |  
|  intersection_update | -- |  
|  isalnum | -- |  
|  isalpha | -- |  
|  isdecimal | -- |  
|  isdigit | -- |  
|  isdisjoint | -- |  
|  is_integer | -- |  
|  islower | -- |  
|  isnumeric | -- |  
|  isspace | -- |  
|  issubset | -- |  
|  issuperset | -- |  
|  istitle | -- |  
|  isupper | -- |  
|  items | -- |  
|  iteritems | -- |  
|  iterkeys | -- |  
|  itervalues | -- |  
|  join | -- |  
|  keys | -- |  
|  ljust | -- |  
|  lower | -- |  
|  lstrip | -- |  
|  numerator | -- |  
|  partition | -- |  
|  pop | -- |  
|  popitem | -- |  
|  real | -- |  
|  remove | -- |  
|  replace | -- |  
|  reverse | -- |  
|  rfind | -- |  
|  rindex | -- |  
|  rjust | -- |  
|  rpartition | -- |  
|  rsplit | -- |  
|  rstrip | -- |  
|  setdefault | -- |  
|  sort | -- |  
|  split | -- |  
|  splitlines | -- |  
|  startswith | -- |  
|  strip | -- |  
|  swapcase | -- |  
|  symmetric_difference | -- |  
|  symmetric_difference_update | -- |  
|  title | -- |  
|  translate | -- |  
|  union | -- |  
|  update | -- |  
|  upper | -- |  
|  values | -- |  
|  viewitems | -- |  
|  viewkeys | -- |  
|  viewvalues | -- |  
|  zfill | -- |  




#### 在清单文件中定义变量

通常，您需要为清单中的单个宿主或一组主机设置变量。
例如，波士顿的计算机可能都使用“ boston.ntp.example.com”作为NTP服务器。 


#### 在剧本中定义变量

您可以直接在剧本中定义变量：

```yml
- hosts: webservers
  vars:
    http_port: 80
```
#### 在被包含的文件和角色中定义变量

如[角色](https://docs.ansible.com/ansible/2.9/user_guide/playbooks_reuse_roles.html#playbooks-reuse-roles)中所述，变量也可以通过包含文件包含在剧本中，而包含文件可能是也可能不是 `Ansible` 角色的一部分。
最好使用角色，因为它提供了一个不错的组织系统

#### 在 `Jinja2` 中使用变量

定义变量后，您可以使用 `Jinja2` 模板系统在您的剧本中使用它们。
这是一个简单的 `Jinja2` 模板：

```yml
My amp goes to {{ max_amp_value }}
```

此表达式提供了变量替换的最基本形式。
您可以在剧本中使用相同的语法。
例如：

```yml
template: 
  src=foo.cfg.j2
   dest={{ remote_install_path }}/foo.cfg
```
在这里，变量定义文件的位置，文件的位置可能因一个系统而异。

在模板内部，您可以自动访问宿主范围内的所有变量。
实际上，不仅如此，您还可以读取有关其他宿主的变量。
我们将稍后展示如何做到这一点。

!> `ansible` 允许在模板中使用 `Jinja2` 循环和条件，但在剧本中，我们不使用它们。 
`Ansible` 剧本是纯机器可解析的 `YAML` 。
这是一个非常重要的功能，因为它意味着可以代码生成文件片段，或让其他生态系统工具读取 `Ansible` 文件。
并非每个人都需要此功能，但它可以释放各种可能性。


#### 使用 `Jinja2` 过滤器转换变量

`Jinja2` 过滤器使您可以转换模板表达式中变量的值。
例如，`capitalize` 将传递给它的任何值大写； 
`to_yaml` 和 `to_json` 过滤器更改变量值的格式。 
`Jinja2` 包含许多内置过滤器，而 `Ansible` 提供了更多过滤器。

#### 一个 `YAML` 的坑

YAML语法要求，如果您使用 `{{foo}}` 开头的值，请用引号将整个行引起来，因为它希望确保您不尝试启动 `YAM` L字典。
这在YAML语法文档中有介绍。

- 不起作用·的：

```yml
- hosts: app_servers
  vars:
      app_path: {{ base_path }}/22
```
- 起作用的

```yml
- hosts: app_servers
  vars:
       app_path: "{{ base_path }}/22"
```

#### 从系统中发现的变量：事实

在其他地方也可以使用变量，但这是一种发现的变量，不是用户设置的。
事实是通过与远程系统对话而获得的信息。
您可以在 `ansible_facts` 变量下找到一个完整的集合，大多数事实也作为保留 `ansible_` 前缀的顶级变量而被“注入”，但由于冲突而被丢弃。
可以通过 [`INJECT_FACTS_AS_VARS`](https://docs.ansible.com/ansible/2.9/reference_appendices/config.html#inject-facts-as-vars) 设置禁用。
例如，远程宿主的IP地址或操作系统是什么。
若要查看可用的信息，请在剧本中尝试以下操作：

```yml
- debug: var=ansible_facts

```
要查看所收集的“原始”信息，请执行以下操作：

```yml
ansible hostname -m setup
```

这将返回大量的变量数据，在 `Ansible 2.7` 上可能看起来像这样：

```json
{
    "ansible_all_ipv4_addresses": [
        "REDACTED IP ADDRESS"
    ],
    "ansible_all_ipv6_addresses": [
        "REDACTED IPV6 ADDRESS"
    ],
    "ansible_apparmor": {
        "status": "disabled"
    },
    "ansible_architecture": "x86_64",
    "ansible_bios_date": "11/28/2013",
    "ansible_bios_version": "4.1.5",
    "ansible_cmdline": {
        "BOOT_IMAGE": "/boot/vmlinuz-3.10.0-862.14.4.el7.x86_64",
        "console": "ttyS0,115200",
        "no_timer_check": true,
        "nofb": true,
        "nomodeset": true,
        "ro": true,
        "root": "LABEL=cloudimg-rootfs",
        "vga": "normal"
    },
    "ansible_date_time": {
        "date": "2018-10-25",
        "day": "25",
        "epoch": "1540469324",
        "hour": "12",
        "iso8601": "2018-10-25T12:08:44Z",
        "iso8601_basic": "20181025T120844109754",
        "iso8601_basic_short": "20181025T120844",
        "iso8601_micro": "2018-10-25T12:08:44.109968Z",
        "minute": "08",
        "month": "10",
        "second": "44",
        "time": "12:08:44",
        "tz": "UTC",
        "tz_offset": "+0000",
        "weekday": "Thursday",
        "weekday_number": "4",
        "weeknumber": "43",
        "year": "2018"
    },
    "ansible_default_ipv4": {
        "address": "REDACTED",
        "alias": "eth0",
        "broadcast": "REDACTED",
        "gateway": "REDACTED",
        "interface": "eth0",
        "macaddress": "REDACTED",
        "mtu": 1500,
        "netmask": "255.255.255.0",
        "network": "REDACTED",
        "type": "ether"
    },
    "ansible_default_ipv6": {},
    "ansible_device_links": {
        "ids": {},
        "labels": {
            "xvda1": [
                "cloudimg-rootfs"
            ],
            "xvdd": [
                "config-2"
            ]
        },
        "masters": {},
        "uuids": {
            "xvda1": [
                "cac81d61-d0f8-4b47-84aa-b48798239164"
            ],
            "xvdd": [
                "2018-10-25-12-05-57-00"
            ]
        }
    },
    "ansible_devices": {
        "xvda": {
            "holders": [],
            "host": "",
            "links": {
                "ids": [],
                "labels": [],
                "masters": [],
                "uuids": []
            },
            "model": null,
            "partitions": {
                "xvda1": {
                    "holders": [],
                    "links": {
                        "ids": [],
                        "labels": [
                            "cloudimg-rootfs"
                        ],
                        "masters": [],
                        "uuids": [
                            "cac81d61-d0f8-4b47-84aa-b48798239164"
                        ]
                    },
                    "sectors": "83883999",
                    "sectorsize": 512,
                    "size": "40.00 GB",
                    "start": "2048",
                    "uuid": "cac81d61-d0f8-4b47-84aa-b48798239164"
                }
            },
            "removable": "0",
            "rotational": "0",
            "sas_address": null,
            "sas_device_handle": null,
            "scheduler_mode": "deadline",
            "sectors": "83886080",
            "sectorsize": "512",
            "size": "40.00 GB",
            "support_discard": "0",
            "vendor": null,
            "virtual": 1
        },
        "xvdd": {
            "holders": [],
            "host": "",
            "links": {
                "ids": [],
                "labels": [
                    "config-2"
                ],
                "masters": [],
                "uuids": [
                    "2018-10-25-12-05-57-00"
                ]
            },
            "model": null,
            "partitions": {},
            "removable": "0",
            "rotational": "0",
            "sas_address": null,
            "sas_device_handle": null,
            "scheduler_mode": "deadline",
            "sectors": "131072",
            "sectorsize": "512",
            "size": "64.00 MB",
            "support_discard": "0",
            "vendor": null,
            "virtual": 1
        },
        "xvde": {
            "holders": [],
            "host": "",
            "links": {
                "ids": [],
                "labels": [],
                "masters": [],
                "uuids": []
            },
            "model": null,
            "partitions": {
                "xvde1": {
                    "holders": [],
                    "links": {
                        "ids": [],
                        "labels": [],
                        "masters": [],
                        "uuids": []
                    },
                    "sectors": "167770112",
                    "sectorsize": 512,
                    "size": "80.00 GB",
                    "start": "2048",
                    "uuid": null
                }
            },
            "removable": "0",
            "rotational": "0",
            "sas_address": null,
            "sas_device_handle": null,
            "scheduler_mode": "deadline",
            "sectors": "167772160",
            "sectorsize": "512",
            "size": "80.00 GB",
            "support_discard": "0",
            "vendor": null,
            "virtual": 1
        }
    },
    "ansible_distribution": "CentOS",
    "ansible_distribution_file_parsed": true,
    "ansible_distribution_file_path": "/etc/redhat-release",
    "ansible_distribution_file_variety": "RedHat",
    "ansible_distribution_major_version": "7",
    "ansible_distribution_release": "Core",
    "ansible_distribution_version": "7.5.1804",
    "ansible_dns": {
        "nameservers": [
            "127.0.0.1"
        ]
    },
    "ansible_domain": "",
    "ansible_effective_group_id": 1000,
    "ansible_effective_user_id": 1000,
    "ansible_env": {
        "HOME": "/home/zuul",
        "LANG": "en_US.UTF-8",
        "LESSOPEN": "||/usr/bin/lesspipe.sh %s",
        "LOGNAME": "zuul",
        "MAIL": "/var/mail/zuul",
        "PATH": "/usr/local/bin:/usr/bin",
        "PWD": "/home/zuul",
        "SELINUX_LEVEL_REQUESTED": "",
        "SELINUX_ROLE_REQUESTED": "",
        "SELINUX_USE_CURRENT_RANGE": "",
        "SHELL": "/bin/bash",
        "SHLVL": "2",
        "SSH_CLIENT": "REDACTED 55672 22",
        "SSH_CONNECTION": "REDACTED 55672 REDACTED 22",
        "USER": "zuul",
        "XDG_RUNTIME_DIR": "/run/user/1000",
        "XDG_SESSION_ID": "1",
        "_": "/usr/bin/python2"
    },
    "ansible_eth0": {
        "active": true,
        "device": "eth0",
        "ipv4": {
            "address": "REDACTED",
            "broadcast": "REDACTED",
            "netmask": "255.255.255.0",
            "network": "REDACTED"
        },
        "ipv6": [
            {
                "address": "REDACTED",
                "prefix": "64",
                "scope": "link"
            }
        ],
        "macaddress": "REDACTED",
        "module": "xen_netfront",
        "mtu": 1500,
        "pciid": "vif-0",
        "promisc": false,
        "type": "ether"
    },
    "ansible_eth1": {
        "active": true,
        "device": "eth1",
        "ipv4": {
            "address": "REDACTED",
            "broadcast": "REDACTED",
            "netmask": "255.255.224.0",
            "network": "REDACTED"
        },
        "ipv6": [
            {
                "address": "REDACTED",
                "prefix": "64",
                "scope": "link"
            }
        ],
        "macaddress": "REDACTED",
        "module": "xen_netfront",
        "mtu": 1500,
        "pciid": "vif-1",
        "promisc": false,
        "type": "ether"
    },
    "ansible_fips": false,
    "ansible_form_factor": "Other",
    "ansible_fqdn": "centos-7-rax-dfw-0003427354",
    "ansible_hostname": "centos-7-rax-dfw-0003427354",
    "ansible_interfaces": [
        "lo",
        "eth1",
        "eth0"
    ],
    "ansible_is_chroot": false,
    "ansible_kernel": "3.10.0-862.14.4.el7.x86_64",
    "ansible_lo": {
        "active": true,
        "device": "lo",
        "ipv4": {
            "address": "127.0.0.1",
            "broadcast": "host",
            "netmask": "255.0.0.0",
            "network": "127.0.0.0"
        },
        "ipv6": [
            {
                "address": "::1",
                "prefix": "128",
                "scope": "host"
            }
        ],
        "mtu": 65536,
        "promisc": false,
        "type": "loopback"
    },
    "ansible_local": {},
    "ansible_lsb": {
        "codename": "Core",
        "description": "CentOS Linux release 7.5.1804 (Core)",
        "id": "CentOS",
        "major_release": "7",
        "release": "7.5.1804"
    },
    "ansible_machine": "x86_64",
    "ansible_machine_id": "2db133253c984c82aef2fafcce6f2bed",
    "ansible_memfree_mb": 7709,
    "ansible_memory_mb": {
        "nocache": {
            "free": 7804,
            "used": 173
        },
        "real": {
            "free": 7709,
            "total": 7977,
            "used": 268
        },
        "swap": {
            "cached": 0,
            "free": 0,
            "total": 0,
            "used": 0
        }
    },
    "ansible_memtotal_mb": 7977,
    "ansible_mounts": [
        {
            "block_available": 7220998,
            "block_size": 4096,
            "block_total": 9817227,
            "block_used": 2596229,
            "device": "/dev/xvda1",
            "fstype": "ext4",
            "inode_available": 10052341,
            "inode_total": 10419200,
            "inode_used": 366859,
            "mount": "/",
            "options": "rw,seclabel,relatime,data=ordered",
            "size_available": 29577207808,
            "size_total": 40211361792,
            "uuid": "cac81d61-d0f8-4b47-84aa-b48798239164"
        },
        {
            "block_available": 0,
            "block_size": 2048,
            "block_total": 252,
            "block_used": 252,
            "device": "/dev/xvdd",
            "fstype": "iso9660",
            "inode_available": 0,
            "inode_total": 0,
            "inode_used": 0,
            "mount": "/mnt/config",
            "options": "ro,relatime,mode=0700",
            "size_available": 0,
            "size_total": 516096,
            "uuid": "2018-10-25-12-05-57-00"
        }
    ],
    "ansible_nodename": "centos-7-rax-dfw-0003427354",
    "ansible_os_family": "RedHat",
    "ansible_pkg_mgr": "yum",
    "ansible_processor": [
        "0",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "1",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "2",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "3",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "4",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "5",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "6",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz",
        "7",
        "GenuineIntel",
        "Intel(R) Xeon(R) CPU E5-2670 0 @ 2.60GHz"
    ],
    "ansible_processor_cores": 8,
    "ansible_processor_count": 8,
    "ansible_processor_threads_per_core": 1,
    "ansible_processor_vcpus": 8,
    "ansible_product_name": "HVM domU",
    "ansible_product_serial": "REDACTED",
    "ansible_product_uuid": "REDACTED",
    "ansible_product_version": "4.1.5",
    "ansible_python": {
        "executable": "/usr/bin/python2",
        "has_sslcontext": true,
        "type": "CPython",
        "version": {
            "major": 2,
            "micro": 5,
            "minor": 7,
            "releaselevel": "final",
            "serial": 0
        },
        "version_info": [
            2,
            7,
            5,
            "final",
            0
        ]
    },
    "ansible_python_version": "2.7.5",
    "ansible_real_group_id": 1000,
    "ansible_real_user_id": 1000,
    "ansible_selinux": {
        "config_mode": "enforcing",
        "mode": "enforcing",
        "policyvers": 31,
        "status": "enabled",
        "type": "targeted"
    },
    "ansible_selinux_python_present": true,
    "ansible_service_mgr": "systemd",
    "ansible_ssh_host_key_ecdsa_public": "REDACTED KEY VALUE",
    "ansible_ssh_host_key_ed25519_public": "REDACTED KEY VALUE",
    "ansible_ssh_host_key_rsa_public": "REDACTED KEY VALUE",
    "ansible_swapfree_mb": 0,
    "ansible_swaptotal_mb": 0,
    "ansible_system": "Linux",
    "ansible_system_capabilities": [
        ""
    ],
    "ansible_system_capabilities_enforced": "True",
    "ansible_system_vendor": "Xen",
    "ansible_uptime_seconds": 151,
    "ansible_user_dir": "/home/zuul",
    "ansible_user_gecos": "",
    "ansible_user_gid": 1000,
    "ansible_user_id": "zuul",
    "ansible_user_shell": "/bin/bash",
    "ansible_user_uid": 1000,
    "ansible_userspace_architecture": "x86_64",
    "ansible_userspace_bits": "64",
    "ansible_virtualization_role": "guest",
    "ansible_virtualization_type": "xen",
    "gather_subset": [
        "all"
    ],
    "module_setup": true
}
```


综上所述， 第一张磁盘的模型可以在模板或剧本中引用为：

```yml
{{ ansible_facts['devices']['xvda']['model'] }}

```

同样，系统报告的宿主名是：

```yml
{{ ansible_facts['nodename'] }}
```
事实常用于条件语句（请参阅条件语句）和模板中。
事实还可用于创建符合特定条件的宿主的动态组


##### 禁用的事实

如果您知道不需要宿主的任何事实数据，并且集中了解系统的所有信息，则可以关闭事实收集。
主要在大量系统上，或者在实验平台上使用Ansible时，这在按推送模式扩展Ansible方面具有优势。
在任何剧本中，只需执行以下操作：

```yml
- hosts: whatever
  gather_facts: no
```


##### 本地事实

正如在剧本一章中讨论的那样，`Ansible` 事实是一种获取有关远程系统数据以用于剧本变量的方法。
通常，这些是由 `Ansible` 中的`setup`模块自动发现的。
用户还可以编写自定义事实模块，如 `API` 指南中所述。
但是，如果您希望有一种简单的方法来提供系统或用户提供的数据以供 `Ansible` 变量使用，而无需编写事实模块，该怎么办？

“ Facts.d”是一种用于用户控制其系统管理方式的机制。

!> 也许“本地事实”有点用词不当，它的意思是“本地提供的用户值”，而不是“集中提供的用户值”，或者事实是什么-“本地动态确定的值”。

如果远程管理系统具有 `/etc/ansible/facts.d` 目录，则此目录中以`.fact`结尾的任何文件都可以是 `JSON` ，`INI` 或返回 `JSON` 的可执行文件，
并且这些文件可以在 `Ansible` 中提供本地事实。
可以使用 `fact_path` 基本关键字指定备用目录。

举个栗子。假设 `/etc/ansible/facts.d/preferences.fact` 包含了：

```ini
[general]
asdf=1
bar=2
```
这将产生一个名为 `general` 的哈希变量事实，其中 `asdf` 和 `bar` 为成员。
要验证这一点，请运行以下命令：

```
ansible <hostname> -m setup -a "filter=ansible_local"
```
您会看到添加了以下事实：

```json
"ansible_local": {
        "preferences": {
            "general": {
                "asdf" : "1",
                "bar"  : "2"
            }
        }
 }
```
可以在 `template/playbook` 中按以下方式访问此数据：


```yml
{{ ansible_local['preferences']['general']['asdf'] }}
```

本地名称空间可防止任何用户提供的事实覆盖系统事实或剧本中其他位置定义的变量。

!> `key=value` 对中的关键部分将在 `ansible_local` 变量内转换为小写。
使用上面的示例，如果 `ini` 文件在 `[general]` 部分中包含`XYZ=3` ，则应该以以下方式访问它：`{{ansible_local ['preferences'] ['general'] ['xyz']}}`
而不是 `{{ansible_local ['preferences'] ['general'] ['XYZ']}}`。
这是因为 `Ansible`使用Python的 `ConfigParser` ，它通过 `optionxform` 方法传递所有选项名称，并且该方法的默认实现将选项名称转换为小写。


如果您有一本剧本正在复制自定义事实，然后运行它，则显式调用以重新运行设置模块可以允许在特定的剧本过程中使用该事实。
否则，它将在下一个收集事实信息的剧集中可用。
这是一个可能看起来像的示例：

```yml
- hosts: webservers
  tasks:
    - name: create directory for ansible custom facts
      file: 
        state=directory
        recurse=yes
        path=/etc/ansible/facts.d
    - name: install custom ipmi fact
      copy:
        src=ipmi.fact
        dest=/etc/ansible/facts.d
    - name: re-read facts after adding custom fact
      setup:
        filter=ansible_local

```

但是，在这种模式下，您也可以编写一个事实模块，并且不妨考虑将此作为选项


##### `Ansible` 版本

为了使剧本的行为适应特定版本的 `ansible` ，可以使用具有以下结构的变量 `ansible_version`：

```json
"ansible_version": {
    "full": "2.0.0.2",
    "major": 2,
    "minor": 0,
    "revision": 0,
    "string": "2.0.0.2"
}

```


##### 缓存的事实

如文档其他部分所示，一台服务器可以引用有关另一台服务器的变量，如下所示：

```yml
{{ hostvars['asdf.example.com']['ansible_facts']['os_family'] }}
```
要禁用“事实缓存”，要做到这一点，Ansible必须已经在当前剧本与“ asdf.example.com”进行了对话，或者在剧本中与更高的进行了对话。
这是ansible的默认配置。

为避免这种情况，Ansible 1.8允许在两次运行剧本之间保存事实，但是必须手动启用此功能。
为什么这可能有用？

对于具有数千个宿主的超大型基础架构，事实高速缓存可以配置为每晚运行。
一小组服务器的配置可以全天临时运行或定期运行。
启用事实缓存后，就不必“命中”所有服务器来引用变量和有关它们的信息。

启用事实高速缓存后，尽管事实上在 `/usr/bin/ansible-playbook` 的当前执行中未与变量进行通讯，但一组中的机器仍可以引用另一组中有关机器的变量。
要从缓存的事实中受益，您将需要在大多数剧本中将` gathering `设置更改为`smart`或 `explicit`，或将 `collect_facts` 设置为 `False` 。

当前，Ansible附带了两个持久性缓存插件：`redis` 和 `jsonfile` 。

要使用 `redis` 配置事实缓存，请在 `ansible.cfg` 中启用它，如下所示：

```ini
[defaults]
gathering = smart
fact_caching = redis
fact_caching_timeout = 86400
# seconds
```
要启动和运行 `redis` ，请执行等效的 `OS` 命令：

```bash
yum install redis
service redis start
pip install redis
```
请注意， `Python redis` 库应该从 `pip` 安装，EPEL中打包的版本太旧，`Ansible` 无法使用。
在当前实施例中，此功能处于beta级别状态，并且Redis插件不支持端口或密码配置，预计这将在不久的将来改变。

要使用 `jsonfile` 配置事实缓存，请在 `ansible.cfg` 中启用它，如下所示：

```yml
[defaults]
gathering = smart
fact_caching = jsonfile
fact_caching_connection = /path/to/cachedir
fact_caching_timeout = 86400
# seconds
```

`fact_caching_connection` 是可写目录的本地文件系统路径（如果一个都木有，`ansible` 将尝试创建该目录）。

`fact_caching_timeout` 是缓存记录的事实的秒数。




#### 注册变量

变量的另一个主要用途是运行命令并将该命令的结果注册为变量。
执行任务并将返回值保存在变量中以供以后的任务使用时，你创建了一个注册变量。
在条件章节中有更多示例。

```yml
- hosts: web_servers

  tasks:

     - shell: /usr/bin/foo
       register: foo_result
       ignore_errors: True

     - shell: /usr/bin/bar
       when: foo_result.rc == 5

```
结果因模块而异。
每个模块的文档都包含一个 `RETURN` 部分，描述该模块的返回值。
要查看特定任务的值，请使用 `-v` 运行您的剧本。
已注册的变量与事实相似，但有一些关键区别。
像事实一样，注册变量是宿主级变量。
但是，注册变量仅存储在内存中。 
（可配置的任何缓存插件均受支持。）已注册的变量仅在宿主上对当前剧本运行的其余部分有效。
最后，注册变量和事实具有不同的优先级。
在具有循环的任务中注册变量时，注册的变量包含循环中每个项目的值。
循环期间放置在变量中的数据结构将包含一个 `result` 属性，该属性是来自模块的所有响应的列表。
有关如何工作的更深入的示例，请参见“将寄存器与循环一起使用”的“循环”部分。

!> 如果任务失败或被跳过，则仍以失败或跳过状态注册变量，避免注册变量的唯一方法是使用标签。


#### 访问复杂的变量数据

我们已经在文档中对事实进行了描述。
提供的某些事实（例如网络信息）可作为嵌套数据结构使用。
要访问它们，简单的 `{{foo}}` 是不够的，但是仍然很容易做到。
这是我们获取IP地址的方法：

```yml
{{ ansible_facts["eth0"]["ipv4"]["address"] }}
```
另一种写法

```yml
{{ ansible_facts.eth0.ipv4.address }}
```
同样地，我们访问数组的第一个元素的方式：

```yml
{{ foo[0] }}
```

#### 使用魔术变量访问有关其他宿主的信息

不管您是否定义任何变量，都可以使用 `Ansible` 提供的特殊变量访问有关宿主的信息，包括“魔术”变量，事实和连接变量。
魔术变量名称是保留的-请勿使用这些名称设置变量。
可变环境也被保留。

最常用的魔术变量是 `hostvars`，`groups` ，`group_names` 和 `inventory_hostname` 。

`hostvars` 使您可以访问其他宿主的变量，包括有关该主机的事实。
您可以在剧本的任何位置访问宿主变量。
即使您尚未在该剧本或一组剧本本中的任何剧本中与该宿主建立连接，您仍然可以获取变量，但您看不到事实。

如果您的数据库服务器希望使用来自另一个节点的“事实”值或分配给另一个节点的清单变量，则可以在模板甚至操作行中轻松使用：

```yml
{{ hostvars['test.example.com']['ansible_facts']['distribution'] }}
```
`groups` 是清单中所有组（和宿主）的列表。
这可用于枚举组中的所有宿主。
例如：

```jinja2
{% for host in groups['app_servers'] %}
   # something that applies to all app servers.
{% endfor %}
```
一个常用的习惯用法是在一个小组中走动，以查找该小组中的所有IP地址。

```jinja2
{% for host in groups['app_servers'] %}
   {{ hostvars[host]['ansible_facts']['eth0']['ipv4']['address'] }}
{% endfor %}
```

您可以使用此惯用法将前端代理服务器指向所有应用程序服务器，在服务器之间设置正确的防火墙规则，等等。
您需要确保之前已填充了这些宿主的事实，例如如果最近没有缓存事实，则对他们进行对抗操作（事实缓存已在Ansible 1.8中添加）。


`group_names` 是当前宿主所在的所有组的列表（数组）。可以使用 `Jinja2` 语法在模板中使用此模板，
以使模板源文件根据宿主的组成员身份（或角色）而有所不同：

```jinja2
{% if 'webserver' in group_names %}
   # some part of a configuration file that only applies to webservers
{% endif %}
```

清单宿主名(`inventory_hostname`)是在 `Ansible` 的清单主机文件中配置的主机名。
如果您禁用了事实收集功能，或者不想依靠发现的宿主名 `ansible_hostname` ，此功能将非常有用。
如果您有较长的 `FQDN` ，则可以使用 `stock_hostname_short`，它包含直到第一个期间的一部分，而没有域的其余部分。
其他有用的魔术变量涉及当前的剧本或剧本，包括：
| 魔术变量  | 描述  |
| ------------ | ------------ |
| ansible_play_hosts  | 是当前剧本中仍处于活动状态的所有宿主的完整列表。  |
| ansible_play_batch  | 可作为宿主名列表使用，这些主机名属于该剧本的当前“批处理”。批次大小由 `serial`  定义，如果未设置，则相当于整个剧本（使其与 `ansible_play_hosts` 相同 ） |
| ansible_playbook_python  | 是用于调用Ansible命令行工具的 `python` 可执行文件的路径。  |
| inventory_dir  | 是保存Ansible的库存宿主文件的目录的路径名  |
| inventory_file  | 指向 Ansible 清单宿主文件的文件名和文件路径 |
| playbook_dir  | 包含剧本的基本目录  |
| role_path  | 它将返回当前角色的路径名（从1.8开始）。这仅在角色内部起作用  |
| ansible_check_mode  | （在版本2.1中添加），这是一个布尔型魔术变量，如果使用 `--check` 运行 `Ansible` ，则会将其设置为 `True`  |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |



#### 在文件中定义变量

将剧本置于源代码控制下是一个好主意，但您可能希望公开该剧本，同时将某些重要变量设为私有的。
同样，有时您可能只想将某些信息保存在不同的文件中，而不是存放在主剧本上。

您可以使用一个或多个外部变量文件来执行此操作，如下所示：

```yml
---

- hosts: all
  remote_user: root
  vars:
    favcolor: blue
  vars_files:
    - /vars/external_vars.yml

  tasks:

  - name: this is just a placeholder
    command: /bin/echo foo
```

这样就消除了与他人共享您的剧本源时与他人共享敏感数据的风险。

每个变量文件的内容都是一个简单的YAML字典，如下所示：

```yml
---
# in the above example, this would be vars/external_vars.yml
somevar: somevalue
password: magic
```

> 也可以将每个宿主和每个组的变量保存在非常相似的文件中，这在组织主机和组的变量中有介绍。






#### 在命令行上传递变量

除了 `vars_prompt` 和 `vars_files` 外，还可以在命令行中使用 `--extra-vars` （或 `-e` ）参数设置变量。
可以使用单引号字符串（包含一个或多个变量）使用以下格式之一定义变量:

键=值格式：

```bash
ansible-playbook release.yml --extra-vars "version=1.23.45 other_variable=foo"
```

> 使用 `key=value` 语法传递的值将解释为字符串。
> 如果您需要传递不应该是字符串的任何内容（布尔值，整数，浮点数，列表等），请使用 `JSON` 格式。

`JSON` 字符串格式：

```bash
ansible-playbook release.yml --extra-vars '{"version":"1.23.45","other_variable":"foo"}'
ansible-playbook arcade.yml --extra-vars '{"pacman":"mrs","ghosts":["inky","pinky","clyde","sue"]}'
```

`JSON` 或 `YAML` 文件中的变量：

```bash
ansible-playbook release.yml --extra-vars "@some_file.json"
```

除其他事项外，这对于设置宿主组或剧本用户非常有用。
对引号和其他特殊字符进行转义：请确保您对标记（例如 `JSON` ）和您在其中运行的 `Shell` 都适当地对引号进行了转义：

```bash
ansible-playbook arcade.yml --extra-vars "{\"name\":\"Conan O\'Brien\"}"
ansible-playbook arcade.yml --extra-vars '{"name":"Conan O'\\\''Brien"}'
ansible-playbook script.yml --extra-vars "{\"dialog\":\"He said \\\"I just can\'t get enough of those single and double-quotes"\!"\\\"\"}"
```
在这种情况下，最好使用包含变量定义的 `JSON` 或 `YAML` 文件


#### 变量优先级：我应该在哪里放置变量？

很多人可能会问变量如何覆盖另一个变量。
归根结底，这是Ansible的理念，那就是更好地知道在哪里放置变量，然后您不必再多考虑了。
避免在47个地方定义变量“ x”，然后问“使用x的问题”。
为什么？
因为那不是Ansible的禅宗哲学。
只有一幢帝国大厦。一个蒙娜丽莎（Mona Lisa）等人。找出要在哪里定义变量，不要太复杂。

但是，让我们继续前进，抢占先机！
它就在那里，您可能会用到它。

这是从最小到最大的优先顺序（最后列出的变量赢得优先顺序）：

| 变量位置  | 排序  |
| ------------ | ------------ |
| 命令行值（"-u user"）  | 1  |
| 角色默认  | 2  |
| 清单文件或脚本组变量  | 3  |
| 清单组变量/所有变量  | 4  |
| 剧本组变量/所有变量  | 5  |
| 清单组变量下的所有  | 6  |
| 剧本组变量下的所有  | 7  |
| 清单文件或脚本宿主变量  | 8  |
| 清单宿主变量  | 9  |
| 剧本宿主变量  | 10  |
| 宿主事实/缓存设置的事实  | 11  |
| 剧变量  | 12  |
| 剧提示变量  | 13  |
| 剧变量文件  | 14  |
| 角色变量（位于 `role/vars/main.yml`）  | 15  |
| 块变量（块中的任务）  | 16  |
| 任务变量（仅对于任务）  | 17  |
| 包含变量  | 18  |
| 设置的事实/注册变量  | 19  |
| 角色（和include_role）参数  | 20  |
| 包含参数  | 21  |
| 额外的变量（始终优先）  | 22  |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |
|   |   |


基本上，任何涉及“角色默认值”（角色内的默认值文件夹）的东西都是最易延展的，并且很容易被覆盖。
角色的 `vars` 目录中的所有内容都会覆盖名称空间中该变量的先前版本。
这里要遵循的想法是，范围越明确，使用命令行的优先级就越高 `-e` 总是赢得额外的` var` 。
主机变量或清单变量可以取代角色默认值，但不能像 `vars` 目录或 `include_vars` 任务那样显式包含。



##### 作用域变量
##### 在哪里设置一个变量
#### 使用高级变量语法 



