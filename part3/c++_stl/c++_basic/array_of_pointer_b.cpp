#include <iostream>

using namespace std;
const int MAX = 3;
int main () {
  int  var[MAX] = {10, 100, 200};
  int *p[MAX];
  for (int i = 0; i < MAX; ++i) {
    p[i] = &var[i] ;//
  }

  for (auto & i : p) {
    cout << "address:" << i <<endl;
  }

  for (auto & i : p) {
    cout << "val:" << *i <<endl;
  }
}