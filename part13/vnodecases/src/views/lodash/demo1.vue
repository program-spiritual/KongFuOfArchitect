<template>
  <div>
    <div id="temp"></div>
    <div id="temp2"></div>
  </div>
</template>

<script>
import { template } from 'lodash'
import { default as compiler } from './MyComponent'
import setTitle from '@/mixins/setTitle'
export default {
  name: 'demo1',
  mixins: [setTitle],
  data() {
    return {
      title: 'lodash_demo1',
    }
  },
  methods: {
    render2DOM() {
      const compiler = template('<h1><%= title %></h1>')
      const html = compiler({ title: 'customer components' })
      document.getElementById('temp').innerHTML = html
    },

    renderWithCompilerFunc() {
      // debugger
      document.getElementById('temp2').innerHTML = compiler({
        title: 'second components',
      })
    },
  },
  mounted() {
    this.render2DOM()
    this.renderWithCompilerFunc()
  },
}
</script>

<style scoped lang="scss"></style>
