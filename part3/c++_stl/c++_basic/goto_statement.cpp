#include <iostream>

using namespace std;

int main() {
  int a = 10;
  LOOP:
  do {
    if (a == 15) {
      a++;
      goto LOOP;
    }
    a++;
    cout << "value of a: " << a << endl;
  } while (a<20);
}