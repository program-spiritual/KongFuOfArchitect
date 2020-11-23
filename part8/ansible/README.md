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

!> 
- 使用 `key=value` 语法以`INI` 格式传递的值根据声明位置的不同而具有不同地解释：

- 当与主机内联声明时，`INI` 值将解释为 `Python` 字面量结构（字符串，数字，元组，列表，字典，布尔值，空）。
主机行每行接受多个 `key=value` 参数。
因此，他们需要一种方法来指示空格是值的一部分而不是分隔符。

- 在 `:vars` 节中声明时，`INI` 值将解释为字符串。
例如，`var=FALSE` 将创建一个等于 "FALSE" 的字符串。
与主机行不同，`:vars` 节每行仅接受一个条目，因此`=`号之后的所有内容都必须是该条目的值。

- 如果 `INI` 清单中设置的变量值必须是某种类型（例如，字符串或布尔值），请始终在任务中使用过滤器指定类型。
使用变量时，请勿依赖 `INI` 清单中设置的类型。

- 考虑将 `YAML` 格式用于清单文件，以避免混淆变量的实际类型。 
`YAML` 清单文件插件可以一致且正确地处理变量值。

!> 


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

###  管理主机和组变量

尽管我们可以将变量存储在主清单文件中，但存储单独的主机变量和组变量文件可以帮助您更轻松地管理变量值。
- 主机和组变量文件必须使用 ` YAM ` L语法。
- 有效的文件扩展名包括` .yml `，` .yaml `，`.json `或 `没有文件扩展名`。
- 如果您不熟悉 `YAML` ，请参见 `YAML` 语法。 

` Ansible `  通过搜索相对于清单文件或剧本文件的路径来加载主机和组变量文件。

如果位于 `/etc/ansible/hosts` 的清单文件包含名为 `foosball` 的主机，该主机属于 `raleigh` 和 `webservers` 两个组，则该主机将在YAML文件中使用变量：


```yml
/etc/ansible/group_vars/raleigh #  可选的文件拓展名： '.yml', '.yaml', 或  '.json'
/etc/ansible/group_vars/webservers
/etc/ansible/host_vars/foosball
```

例如，如果按数据中心将清单中的主机们分组，并且每个数据中心使用其自己的 `NTP` 服务器和数据库服务器，则可以创建一个名为 `/etc/ansible/group_vars/raleigh` 的文件来存储 `raleigh` 组的变量：

```yml
/etc/ansible/group_vars/raleigh/db_settings
/etc/ansible/group_vars/raleigh/cluster_settings
```

`raleigh`  组中的所有主机都可以使用这些文件中定义的变量。
当单个文件太大或要在某些组变量上使用 `Ansible Vault` 时，这对于保持变量的组织性非常有用。

您还可以将 `group_vars/` 和 `host_vars/` 目录添加到您的剧本目录中。
缺省情况下，`ansible-playbook` 命令在当前工作目录中查找这些目录。
其他 `Ansible` 命令（例如，`ansible` ，`ansible-console` 等）将仅在清单目录中查找 `group_vars`  /和 `host_vars/` 。
如果要其他命令从剧本目录加载组和主机变量，则必须在命令行上提供 `--playbook-dir` 选项。
如果您同时从 `Playbook` 目录和清单目录中加载清单文件，则 `Playbook` 目录中的变量将覆盖在清单目录中设置的变量。
将清单文件和变量保存在 `git repo` （或其他版本控制工具）中，是跟踪清单和主机变量的更改的绝佳方法。


### 变量是如何合并的？ 

默认情况下，在运行剧本之前，变量会合并或延展到指定主机。
这使得 `Ansible` 可以专注于主机和任务，因此组无法真正在清单文件和除匹配的主机之外的环境中存活。
默认情况下，`Ansible` 会覆盖变量，包括为组或主机定义的变量.
顺序或优先顺序是（从最低到最高）：

- 所有组（因为它是所有其他组的根）
- 父级组
- 子级组
- 主机


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
这对于组合静态和动态主机并将它们作为一个清单进行管理很有用。
以下清单结合了清单插件源，动态清单脚本和具有静态主机的文件：

```yml
inventory/
  openstack.yml          # 配置清单插件以从Openstack Cloud 获取主机们 
  dynamic-inventory.py   # 使用动态清单脚本添加其他主机
  static-inventory       # 添加静态主机和组
  group_vars/
    all.yml              # 将变量分配给所有主机
```

您可以像下面这样定位此清单目录：

```
ansible-playbook example.yml -i inventory
```

如果存在与其他清单源之间的变量冲突或组依赖关系，则控制清单资源的合并顺序会很有用。
根据文件名按字母顺序合并清单，因此可以通过在文件名之前添加前缀来控制结果：

```yml

inventory/
  01-openstack.yml          # 配置清单插件以从 Openstack Cloud 获取主机 
  02-dynamic-inventory.py   # 使用动态清单脚本添加其他主机
  03-static-inventory       # 添加静态主机和组 
  group_vars/
  all.yml                   # 将变量分配给所有主机


```

如果 `01-openstack.yml` 为所有组定义了 `myvar = 1` ，`02-dynamic-inventory.py` 定义 `myvar = 2` ，而 `03-static-inventory` 定义 `myvar = 3` ，则将以 `myvar = 3` 运行该剧本。

### 连接到主机：行为清单参数

#### 主机连接：

!> 当使用 `ssh` 连接插件（默认设置）时，`Ansible` 不会公开允许用户和 `ssh` 进程之间通信的通道，以手动接受密码来解密 `ssh` 密钥。
强烈建议使用 `ssh-agent` 。

- ansible_connection

主机的连接类型。
可以是任何 `ansible` 连接插件的名称。 
SSH协议类型为 `smart`，`ssh` 或 `paramiko` 。
默认为 `smart` 。
下一节将介绍基于非 `SSH` 的类型。

所有连接的常规参数：

- ansible_host
- 要连接的主机名，如果与您要给它提供的别名不同。
- ansible_port
- 连接端口号（如果不是默认值）（ssh为22）
- ansible_user
- 连接到主机时要使用的用户名
- ansible_password
- 用于验证主机的密码（切勿以纯文本形式存储此变量；建议使用 vault

特定于SSH连接：

- ansible_ssh_private_key_file
 ssh使用的私钥文件。如果使用多个密钥并且您不想使用 `SSH` 代理，则很有用。
- ansible_ssh_common_args
 此设置始终附加到 `sftp` ，`scp` 和 `ssh` 的默认命令行中。为特定主机（或组）配置 `ProxyCommand` 很有用。
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

`Ansible-INI` 主机文件中的示例：


```yml

some_host         ansible_port=2222     ansible_user=manager
aws_host          ansible_ssh_private_key_file=/home/example/.ssh/aws.pem
freebsd_host      ansible_python_interpreter=/usr/local/bin/python
ruby_module_host  ansible_ruby_interpreter=/usr/bin/ruby.1.9.3


```

非SSH连接类型

如上一节所述，`Ansible` 通过 `SSH` 执行剧本，但不限于此连接类型。
使用主机特定的参数 `ansible_connection=<connector> ` ，可以更改连接类型。
以下基于非 `SSH` 的连接器可用：

- local
该连接器可用于将剧本部署到控制主机（节点）本身。
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

如果您需要管理多个环境，有时明智的做法是每个清单文件只定义一个环境的主机。
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
该文件仅包含属于测试环境的主机。

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

在上一节中，您已经看到了使用组对具有相同功能的主机进行集群配置的示例。
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


其他任务可能集中在某个主机所在的位置。
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
如果您拥有的主机数量超过为派生计数设置的值，则 `Ansible` 会与它们对话，但是会花费更长的时间。
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

针对一组主机定义并运行单个任务“剧本”

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
此命令允许您针对一组主机定义和运行单个任务“剧本”

#### 公共参数：

| 参数  | 描述  |
| ------------ | ------------ |
| --ask-vault-pass  | 要求提供保险库密码  |
| --become-method <BECOME_METHOD>  | 要使用的特权升级方法(default=%(default)s)，请使用 `ansible-doc -t` 成为 `-l `列出有效的选择。  |
| --become-user <BECOME_USER>  | 以该用户身份运行操作（默认= root）  |
| --list-hosts  | 输出匹配主机列表；不执行其他任何操作  |
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
| -i, --inventory, --inventory-file   |  指定清单主机路径或逗号分隔的主机列表。 –不推荐使用库存文件   |
| -k, --ask-pass   |  询问连接密码   |
| -l <SUBSET>, --limit <SUBSET>  |  将所选主机进一步限制为其他模式   |
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


#### 动作

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
| --host <HOST>  | 输出指定的主机信息，用作清单脚本  |
| --list  | 输出特定的主机信息，用作清单脚本  |
| --list-hosts  |   |
| --output <OUTPUT_FILE>  | 执行`–list` 时，将清单发送到文件而不是发送到屏幕  |
| --playbook-dir <BASEDIR>  | 由于此工具不使用剧本，因此可以将其用作替代剧本目录，从而为许多功能（包括 `role/group_vars/` 等）设置相对路径。  |
| --toml  | 使用 TOML 格式而不是默认 JSON ，对 `–graph` 忽略  |
| --vars | 将变量添加到图形显示，除非与 `–graph` 一起使用，否则将被忽略  |  
| --vault-id  | 要使用的库身份  |
| --vault-password-file  | 保险库密码文件  |
| --version  | 显示程序的版本号，配置文件位置，配置的模块搜索路径，模块位置，可执行文件位置然后退出  |
|  -h, --help  | 显示此帮助消息并退出   |
| -i, --inventory, --inventory-file  | 指定清单主机路径或逗号分隔的主机列表。–不推荐使用 --inventory-file |
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
| --flush-cache  | 清除清单中每个主机的事实缓存  |
| --force-handlers  | 即使任务失败也运行处理程序  |
| --list-hosts  | 输出匹配主机列表 .不执行其他任何操作  |
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
| -i, --inventory, --inventory-file  | 指定清单主机路径或逗号分隔的主机列表。 –不推荐使用 --inventory-file  |
| -k, --ask-pass  | 询问连接密码  |
| -l <SUBSET>, --limit <SUBSET>  | 将所选主机进一步限制为其他模式  |
| -t, --tags  | 只运行带有这些值标记的剧本和任务  |
| -u <REMOTE_USER>, --user <REMOTE_USER>  | 以该用户身份连接（默认=无）  |
| -v, --verbose  | 详细模式（-vvv用于更多，-vvvv用于启用连接调试）  |
|   |   |
|   |   |
|   |   |

