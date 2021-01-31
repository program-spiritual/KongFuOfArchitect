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

using namespace first_namespace;
int main () {
    // This calls function from first name space.
    func();
    return 0;
}
