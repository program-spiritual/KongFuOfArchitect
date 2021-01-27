#include <iostream>

#include <ctime>

using namespace std;

// 生成并返回随机数。

int* getRandom();

int main(){
  int *p;
  p = getRandom();
  for ( int i = 0; i < 10; i++ ) {
    cout << "*(p + " << i << ") : ";
    cout << *(p + i) << endl;
  }
  return 0;
}

int* getRandom(){
  static int r[10];
  // set the seed
  srand((unsigned) time(nullptr));
  for (int i = 0; i < 10; ++i) {
    r[i] = rand();
    cout << r[i] << endl;
  }
  return r;
}