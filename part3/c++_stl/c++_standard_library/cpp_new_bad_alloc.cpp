#include <iostream>
#include <memory>

int main(){
  try {
    while (true) {
      new int[100000000ul];
    }
  } catch (const std::bad_alloc &e) {
    std::cout << "Allocation failed: " << e.what() << '\n';
  }
}