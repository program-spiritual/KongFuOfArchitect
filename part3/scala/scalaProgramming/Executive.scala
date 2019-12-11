package society {
  package professional {
//    private [X]或protected [X]的修饰符表示访问是私有的或受保护的，
//   最多X个，其中X指定一些封闭的包，类或单例对象。
    class Executive {
      private[professional] var workDetails = null // professional 包内可见
      private[society] var friends = null // society 包内可见
      private[this] var secrets = null

      def help(another : Executive) {
        println(another.workDetails)
//        println(another.secrets) //ERROR // 该实例方法中的隐式对象 可见
      }
    }
  }
}