export default {
  methods: {
    setTitle() {
      document.title = this.title
    },
  },
  created() {
    this.setTitle()
  },
}
