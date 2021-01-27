#include <iostream>

using namespace std;
const int MAX = 4;
int main () {
  const char *names[MAX] = { "Zara Ali", "Hina Ali", "Nuha Ali", "Sara Ali" };
  for (int i = 0; i < MAX; ++i) {
    cout << "name:" << i <<endl;
    cout << "val:" << names[i] <<endl;
    cout << "address:" << (names+i) <<endl;
  }
}