#include <iostream>
#include <memory>
#include <new>
using namespace std;
int main(){
  try {
    int* p = new int[-1];
  } catch (bad_array_new_length &e) {
    std::cerr << "bad_array_new_length caught: " << e.what() << '\n';
  } catch (std::exception& e) {
    std::cerr << "some other standard exception caught: " << e.what() << '\n';
  }
}
