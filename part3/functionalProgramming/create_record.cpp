#include<iostream>
#include<string>
using namespace std;

class student {
public:
    string sname;
    int sid;
};

int main() {
    student S;
    S.sname = "Sachin";
    S.sid = 5;
    cout<<S.sid<<"\n"<<S.sname;
    cout<<"\n"<< "value after updating"<<"\n";
    S.sid = 10;
    cout<<S.sname<<"\n"<<S.sid;
    return 0;
}
