<template>
  <div></div>
</template>

<script>
// const elementVnode = {
//   tag: 'div',
// }

/**
 *@author xiaosanye
 *@date 2021/3/26
 *@param vnode {Object}
 *@param container {HTMLElement}
 */
// function mountElement(vnode, container) {
//   // --------------------------------------------------
//   // description:2021/3/26 创建元素
//   // --------------------------------------------------
//   const el = document.createElement(vnode.tag)
//   // --------------------------------------------------
//   // description:2021/3/26 将元素添加到容器
//   // --------------------------------------------------
//   container.appendChild(el)
// }
/**
 *@author xiaosanye
 *@date 2021/3/26
 *@param vnode {Object}
 * @param vnode.tag {Class}
 *@param container {HTMLElement}
 */
// function mountComponent(vnode, container) {
//   // 创建组件实例
//   const instance = new vnode.tag()
//   // 渲染
//   instance.$vnode = instance.render()
//   // 挂载
//   mountElement(instance.$vnode, container)
// }

/**
 *@author xiaosanye
 *@date 2021/3/26
 *@param vnode {Object}
 *@param container {HTMLElement}
 */
// function render(vnode, container) {
//   typeof vnode.tag === 'string' && mountElement(vnode, container)
//   typeof vnode.tag !== 'string' && mountComponent(vnode, container)
// }

// 把 elementVnode 渲染到 id 为 app 的元素下
// render(elementVnode, document.getElementById('app'))
// class MyComponent {
//   render() {
//     // render 函数产出 VNode
//     return {
//       tag: 'div',
//     }
//   }
// }

// const componentVNode = {
//   tag: MyComponent,
// }

export default {
  name: 'demo2',
}
</script>

<style scoped></style>
