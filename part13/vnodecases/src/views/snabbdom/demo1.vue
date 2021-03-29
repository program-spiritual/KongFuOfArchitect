<template>
  <div>
    <button @click="changeData">改变数据</button>
    <div id="demo1"></div>
  </div>
</template>

<script>
import { h } from 'snabbdom/build/package/h'
import { init } from 'snabbdom/build/package/init'

const MyComponent = props => {
  return h('h1', props.title)
}

// init 方法用来创建 patch 函数
const patch = init([])
export default {
  name: 'demo1',
  data() {
    return {
      prev: '',
    }
  },
  methods: {
    changeData() {
      // 数据变更，产出新的 VNode
      const nextVnode = MyComponent({ title: 'next' })
      // 通过对比新旧 VNode，高效地渲染真实 DOM
      patch(this.prev, nextVnode)
    },
  },
  mounted() {
    // 组件的产出是 VNode
    const prevVnode = MyComponent({ title: 'prev' })
    this.prev = prevVnode
    // 将 VNode 渲染成真实 DOM
    patch(document.getElementById('demo1'), prevVnode)
  },
}
</script>

<style scoped lang="scss"></style>
