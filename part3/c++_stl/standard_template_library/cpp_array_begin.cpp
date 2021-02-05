#include <iostream>
#include <array>

using namespace std;

int main(){
  array<int, 5> array = {1, 2, 3, 4, 5};
  /*迭代器指向数组的开头*/
  auto itr = array.begin();
//  遍历完整容器
  while (itr != array.end()) {
    cout << *itr <<endl;
    itr++;
  }
}