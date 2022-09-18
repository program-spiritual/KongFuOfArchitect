#include <iostream>

using namespace std;

class A {
public:
    void show() {
        cout << "A class method is called \n";
    }
};

class B:public A {
public:
    void show() {
        cout << "B class method is called \n";
    }
};

int main() {
    A x;        // Base class object
    B y;        // Derived class object
    x.show();   // A class method is called
    y.show();   // B class method is called
    return 0;
}
