# vnodecases

> Vue VNode 示例 和 实例演示

## lodash 模板

[code](src/views/lodash/demo1.vue)

|本质|模板引擎|现代化框架|
|----------|------------|------------|
|组件产出|html字符串|Virtual DOM|

## 演示目录

[使用 snabbdom 创建一个 VNode](src/views/snabbdom/demo1.vue)

Vnode 节点：

```json
{
  "sel": "h1",
  "data": {},
  "children": "__vue_devtool_undefined__",
  "text": "prev",
  "elm": "[object HTMLHeadingElement]",
  "key": "__vue_devtool_undefined__"
}
```

> 组件的产出就是 Virtual DOM。

这里 VNode =  Virtual DOM



## 项目运行和启动

## Project setup

```
yarn install
```

### Compiles and hot-reloads for development

```
yarn serve
```

### Compiles and minifies for production

```
yarn build
```

### Lints and fixes files

```
yarn lint
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).
