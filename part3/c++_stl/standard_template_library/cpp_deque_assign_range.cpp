/**
* C++函数std::deque::assign()通过替换旧值将新值分配给deque。

从头到尾的范围构造新元素。
**/

#include <iostream>
#include <deque>

using namespace std;

int main(){
  deque<int> d1 = {1, 2, 3, 4, 5};
  deque<int> d2;
  d2.assign(d1.begin(), d1.begin() + 3);
  cout << "Contents of deque d2 are" << endl;
  for (int i : d2)
    cout << i << endl;

  return 0;
}
