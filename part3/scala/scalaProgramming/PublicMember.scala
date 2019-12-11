class PublicMember {
  class Inner {
    def f() { println("f") }

    class InnerMost {
      f() // OK
    }
  }
  (new Inner).f() // OK because now f() is public
}
