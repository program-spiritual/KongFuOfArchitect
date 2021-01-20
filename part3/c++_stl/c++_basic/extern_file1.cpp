#include <iostream>
/**
 * 你可以通过 g++ 编译：
 * g++ extern_file1.cpp extern_support.cpp -o write
 */
using namespace std;
int count;

extern void write_extern();

int main() {
  count = 5;
  write_extern();
}

