#include <iostream>

using namespace std;

int main(){
  int a = 10;
  do {
    cout << "value of a:" << a << endl;
    a++;
    if (a > 15) {
      break;
    }
  } while (a<20);
}