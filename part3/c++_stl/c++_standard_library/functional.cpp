#include <functional>
#include <iostream>

using namespace std;

struct Foo {
  explicit Foo(int num) : num_(num) {}

  void print_add(int i) const {
    cout << num_ + i << endl;
  }

  int num_;
};

void print_num(int i){
  cout << i << '\n';
}

struct PrintNUm{
  void operator()(int i) const {
    std::cout << i << '\n';
  }
};


int main() {
  function<void(int)> f_display = print_num;
  f_display(-9);

  function<void()> f_display_42 = []() { print_num(42); };
  f_display_42();

  std::function<void()> f_display_31337 = [] { return print_num(31337); };
  f_display_31337();

  std::function<void(const Foo &, int)> f_add_display = &Foo::print_add;
  const Foo foo(314159);
  f_add_display(foo, 1);

  std::function<int(Foo const &)> f_num = &Foo::num_;
  std::cout << "num_: " << f_num(foo) << '\n';

  using std::placeholders::_1;
  std::function<void(int)> f_add_display2 = [foo](auto && PH1) { foo.print_add(std::forward<decltype(PH1)>(PH1)); };
  f_add_display2(2);

  std::function<void(int)> f_add_display3 = [ObjectPtr = &foo](auto && PH1) { ObjectPtr->print_add(std::forward<decltype(PH1)>(PH1)); };
  f_add_display3(3);

  std::function<void(int)> f_display_obj = PrintNUm();
  f_display_obj(18);
}
