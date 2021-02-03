#include <iostream>
#include <memory>
using namespace std;
int main(){
  allocator<int> alloc;
  default_delete<int> del;
  shared_ptr<int> foo = allocate_shared<int>(alloc, 100);
  auto bar = std::allocate_shared<int> (alloc,200);
  auto baz = std::allocate_shared<std::pair<int,int>> (alloc,300,400);
  std::cout << "*foo: " << *foo << '\n';
  std::cout << "*bar: " << *bar << '\n';
  std::cout << "*baz: " << baz->first << ' ' << baz->second << '\n';

}