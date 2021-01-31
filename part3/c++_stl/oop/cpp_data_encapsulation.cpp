#include <iostream>
using namespace std;

class Adder {
public:
    // constructor
    explicit Adder(int i = 0) {
        total = i;
    }

    // interface to outside world
    void addNum(int number) {
        total += number;
    }

    // interface to outside world
    int getTotal() const {
        return total;
    };

private:
    // hidden data from outside world
    int total;
};

int main() {
    Adder a;

    a.addNum(10);
    a.addNum(20);
    a.addNum(30);

    cout << "Total " << a.getTotal() <<endl;
    return 0;
}
