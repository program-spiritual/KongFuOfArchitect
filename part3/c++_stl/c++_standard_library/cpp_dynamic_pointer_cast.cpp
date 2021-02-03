#include <iostream>
#include <memory>
using namespace std;
struct A {
  static const char *static_type;
  const char *dynamic_type;

  explicit A(const char *dynamicType) : dynamic_type(static_type) {}

  A();
};

struct B : A {
  B();

  static const char *static_type;

  explicit B(const char *dynamicType) : A(dynamicType) {
    dynamic_type = static_type;
  }

};

const char* A::static_type = "sample text A";

A::A() {
  dynamic_type = static_type;
}

const char* B::static_type = "sample text B";

B::B() {
  dynamic_type = static_type;
}

int main(){
  shared_ptr<A> foo;
  shared_ptr<B> bar;
  bar = std::make_shared<B>();
  foo = std::dynamic_pointer_cast<A>(bar);
  std::cout << "foo's static type: " << foo->static_type << '\n';
  std::cout << "foo's dynamic type: " << foo->dynamic_type << '\n';
  std::cout << "bar's static type: " << bar->static_type << '\n';
  std::cout << "bar's dynamic type: " << bar->dynamic_type << '\n';
}