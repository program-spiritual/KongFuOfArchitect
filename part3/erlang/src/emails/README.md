## 发送邮件


发送邮件我们将使用开源项目：

[gen_smtp](https://github.com/gen-smtp/gen_smtp)

该链接包含一个 `smtp` 实用程序，可用于从 `Erlang` 应用程序发送电子邮件。
请按照以下步骤操作，以便能够从`Erlang` 发送电子邮件:

- 从github站点下载erl文件。
这些文件应下载到helloworld.erl应用程序所在的目录。

- 使用 `erlc` 命令编译以下列表中显示的所有与smtp相关的文件。
需要编译以下文件。
  - smtp_util
  - gen_smtp_client
  - gen_smtp_server
  - gen_smtp_server_session
  - binstr
  - gen_smtp_application
  - socket

!> 注意：`smtp` 服务可以和谷歌服务一起使用。你需要指定指定 `smtp` 服务的依赖服务商。自己需要提供一份可以发送邮件的账号和密码。
