#include <iostream>

using namespace std;

class Adder{
public:
    explicit Adder(int i = 0){
        total = i;
    };

    // interface to outside world
    void addNumber(int number){
        total += number;
    }

    // interface to outside world
    int getTotal() const{
        return total;
    }
private:
    // hidden data from outside world
    int total;
};

int main() {
    Adder a;

    a.addNumber(10);
    a.addNumber(20);
    a.addNumber(30);

    cout << "Total " << a.getTotal() <<endl;
    return 0;
}
