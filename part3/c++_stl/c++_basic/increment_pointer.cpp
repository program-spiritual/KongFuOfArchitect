#include <iostream>

using namespace std;

const int MAX = 3;

int main(){
  int var[MAX] = {10, 100, 200};
  int *ptr;
  ptr = var;
  for (int i = 0; i < MAX; ++i) {
    cout << "Address of var[" << i << "]=";
    cout << ptr << endl;
    cout << "Value of var[" << i << "] = ";
    cout << *ptr << endl;

    // point to the next location
    ptr++;
  }
}