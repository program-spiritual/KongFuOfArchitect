#include <iostream>
#include <array>
#include <stdexcept>

using namespace std;

int main() {
  array<int, 5> arr = {10, 20, 30, 40, 50};
  size_t i;
  for (i = 0; i < 5; ++i)
    cout << arr.at(i) << " " <<endl;
  try {
    arr.at(100);
  } catch (out_of_range &e) {
    cerr << "one error occurred:" << e.what() << endl;
  }
}