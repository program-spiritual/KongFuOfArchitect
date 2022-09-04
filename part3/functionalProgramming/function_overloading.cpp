#include <iostream>
using namespace std;
void addnum(int,int);
void addnum(int,int,int);



void addnum (int x, int y) {
    cout<<"Integer number: "<<x+y<<endl;
}

void addnum (int x, int y, int z) {
    cout<<"Float number: "<<x+y+z<<endl;
}

int main() {
    addnum (5,5);
    addnum (5,2,8);
    return 0;
}
