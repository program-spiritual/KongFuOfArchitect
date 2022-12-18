#include <iostream>
#include <fstream>
// - fstream 是用于控制文件读/写操作的流类。
//- ofstream 是用于将内容写入文件的流类。
using namespace std;

int main () {
    ofstream myfile;
    myfile.open ("Tempfile.txt", ios::out);
    myfile << "Writing Contents to file.\n";
    cout << "Data inserted into file";
    myfile.close();
    return 0;
}
