#include <iostream>
#include <memory>

using namespace std;
int main(){
  shared_ptr<int> foo = make_shared<int>(100);
  shared_ptr<int> foo2(new int(100));
  auto bar = make_shared<int>(200);
  auto baz = make_shared<pair<int, int>>(300, 400);
  std::cout << "*foo: " << *foo << '\n';
  std::cout << "*bar: " << *bar << '\n';
  std::cout << "*baz: " << baz->first << ' ' << baz->second << '\n';
}