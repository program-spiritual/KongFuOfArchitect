class PrivateMember {
  class Inner {
//    f 已经是私有方法
    private def f() { println("f") }

    class InnerMost {
      f() // OK
    }
  }
//  (new Inner).f()
}
