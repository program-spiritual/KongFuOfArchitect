#include <iostream>

using namespace std;

int main(){
    double *pValue = nullptr;
    pValue = new double;
    *pValue = 29494.99;   // Store value at allocated address
    cout << "Value of pvalue : " << *pValue << endl;

    delete pValue;         // free up the memory.

    return 0;
}
