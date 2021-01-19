#include <iostream>
#include <accctrl.h>

using namespace std;

int main() {
  int i, j, k;
  char c, ch;
  float f, salary;
  double d;
  extern int d1, f1;    // declaration of d and f.
  int d2 = 3, f2 = 5;           // definition and initializing d and f.
  byte z = 22;                // definition and initializes z.
  char x = 'x';               // the variable x has the value 'x'.
  cout << "d1:" << d2 << "f1:" << f2 << endl;
  return 0;
}
