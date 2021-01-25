#include <iostream>

using namespace std;

extern int sum(int a, int b=20);

int main() {
  int a = 100;
  int b = 200;
  int result = sum(a, b);
  cout << "result1:" << result << endl;
  // 重新使用默认的方式调用
  cout << "result2:" << sum(a) << endl;
}
