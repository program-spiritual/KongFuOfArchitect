#include <iostream>
using namespace std;
int function1(int x, int y) {
    int c;
    c = x + y;
    return c;
}

int main() {
    int res;
    res = function1(4,5);
    cout<<"Sum is: "<<res;
    return 0;
}
