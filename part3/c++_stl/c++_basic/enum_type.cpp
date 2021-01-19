#include <iostream>

using namespace std;

int main() {
  enum color {
    red, green = 5, blue
  };
  cout << "color value:" << blue;
  return 0;
};