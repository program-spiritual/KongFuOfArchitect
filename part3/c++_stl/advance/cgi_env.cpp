#include <iostream>

#include <cstdlib>

using namespace std;

const string ENV[ 24 ] = {
        "COMSPEC", "DOCUMENT_ROOT", "GATEWAY_INTERFACE",
        "HTTP_ACCEPT", "HTTP_ACCEPT_ENCODING",
        "HTTP_ACCEPT_LANGUAGE", "HTTP_CONNECTION",
        "HTTP_HOST", "HTTP_USER_AGENT", "PATH",
        "QUERY_STRING", "REMOTE_ADDR", "REMOTE_PORT",
        "REQUEST_METHOD", "REQUEST_URI", "SCRIPT_FILENAME",
        "SCRIPT_NAME", "SERVER_ADDR", "SERVER_ADMIN",
        "SERVER_NAME","SERVER_PORT","SERVER_PROTOCOL",
        "SERVER_SIGNATURE","SERVER_SOFTWARE" };

int main () {
    cout << "Content-type:text/html\r\n\r\n";
    cout << "<html>\n";
    cout << "<head>\n";
    cout << "<title>CGI Environment Variables</title>\n";
    cout << "</head>\n";
    cout << "<body>\n";
    cout << R"(<table border = "0" cellspacing = "2">)";

    for (const auto &i : ENV) {
        cout << "<tr><td>" << i << "</td><td>";

        // attempt to retrieve value of environment variable
        char *value = getenv(i.c_str());
        if (value != nullptr) {
            cout << value;
        } else {
            cout << "Environment variable does not exist.";
        }
        cout << "</td></tr>\n";
    }

    cout << "</table><\n";
    cout << "</body>\n";
    cout << "</html>\n";
}

