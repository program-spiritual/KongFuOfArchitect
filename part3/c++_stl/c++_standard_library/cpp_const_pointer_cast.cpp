#include <iostream>
#include <memory>

using namespace std;

int main() {
  shared_ptr<int> foo;
  shared_ptr<const int> bar;
  foo = make_shared<int>(100);
  bar = const_pointer_cast<const int>(foo);
  std::cout << "*bar: " << *bar << '\n';
  *foo = 200;
  std::cout << "*bar: " << *bar << '\n';
}