#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main () {
    string readfile;
    ifstream myfile ("Tempfile.txt",ios::in);

    if (myfile.is_open()) {
        while ( getline (myfile,readfile) ) {
            cout << readfile << '\n';
        }
        myfile.close();
    } else
        cout << "file doesn't exist";
    return 0;
}
