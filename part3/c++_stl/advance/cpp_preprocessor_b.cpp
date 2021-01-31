#include <iostream>

using namespace std;

#define MKSTR(x) #x
#define concat(a, b) a ## b

int main() {
    cout << MKSTR(HELLO C++) << endl;
    int xy = 100;

    cout << concat(x, y);
    return 0;
}
