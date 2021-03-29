<template>
  <div class="app-wrapper">
    <app-main />
  </div>
</template>

<script>
import { AppMain } from './components'

export default {
  name: 'Layout',
  components: {
    AppMain,
  },
}
</script>

<style lang="scss" scoped>
.app-wrapper {
  /*sad */
  position: relative;
  height: 100%;
  width: 100%;
}
</style>
