#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
#include <cstdlib>

#include <cgicc/CgiDefs.h>
#include <cgicc/Cgicc.h>
#include <cgicc/HTTPHTMLHeader.h>
#include <cgicc/HTMLClasses.h>

using namespace std;
using namespace cgicc;

int main () {
    Cgicc formData;

    cout << "Content-type:text/html\r\n\r\n";
    cout << "<html>\n";
    cout << "<head>\n";
    cout << "<title>Using GET and POST Methods</title>\n";
    cout << "</head>\n";
    cout << "<body>\n";

    auto fi = formData.getElement("first_name");
    if( !fi->isEmpty() && fi != (*formData).end()) {
        cout << "First name: " << **fi << endl;
    } else {
        cout << "No text entered for first name" << endl;
    }

    cout << "<br/>\n";
    fi = formData.getElement("last_name");
    if( !fi->isEmpty() &&fi != (*formData).end()) {
        cout << "Last name: " << **fi << endl;
    } else {
        cout << "No text entered for last name" << endl;
    }

    cout << "<br/>\n";
    cout << "</body>\n";
    cout << "</html>\n";

    return 0;
}
