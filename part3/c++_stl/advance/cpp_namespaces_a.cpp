#include <iostream>
using namespace std;

// first name space
namespace first_namespace{
    void func() {
        cout << "Inside first_space" << endl;
    }
}
namespace second_namespace{
    void func() {
        cout << "Inside second_space" << endl;
    }
}
int main () {
    // Calls function from first name space.
    first_namespace::func();

    // Calls function from second name space.
    second_namespace::func();

    return 0;
}
