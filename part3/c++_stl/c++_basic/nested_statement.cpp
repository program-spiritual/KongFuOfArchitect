#include <iostream>

using namespace std;

int main() {
  int a = 100;
  int b = 200;
  if (a == 100) {
    if (b == 200) { cout << "value a equals 100 and b equals 200"; }
  }
  cout << "Exact value of a is : " << a << endl;
  cout << "Exact value of b is : " << b << endl;
  switch(a) {
    case 100:
      cout << "This is part of outer switch" << endl;
      switch(b) {
        case 200:
          cout << "This is part of inner switch" << endl;
      }
  }
  return 0;
}