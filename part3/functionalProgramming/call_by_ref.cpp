#include <iostream>
using namespace std;

void swap(int *a, int *b) {
    int temp;
    temp = *a;
    cout<<"\n"<<"address of a inside the function: "<<a;
    cout<<"\n"<<"address of a inside the function: "<<temp;
    *a = *b;
    *b = temp;
    cout<<"\n"<<"value of a inside the function: "<<*a;
    cout<<"\n"<<"value of b inside the function: "<<*b;
}
int main() {
    int a = 50, b = 75;
    cout<<"\n"<<"value of a before sending to function: "<<a;
    cout<<"\n"<<"value of b before sending to function: "<<b;
    swap(&a, &b);  // passing value to function
    cout<<"\n"<<"value of a after sending to function: "<<a;
    cout<<"\n"<<"value of b after sending to function: "<<b;
    return 0;
}
