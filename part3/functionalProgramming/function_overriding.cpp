#include <iostream>
using namespace std;

class A {
public:
    void display() {
        cout<<"Base class";
    }
};

class B:public A {
public:
    void display() {
        cout<<"Derived Class";
    }
};

int main() {
    B obj;
    obj.display();
    return 0;
}
