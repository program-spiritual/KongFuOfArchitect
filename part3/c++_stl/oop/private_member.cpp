#include <iostream>

using namespace std;

class Box {
public:
  double length;
private:
  double width;
public:
  double getWidth() const {
    return width;
  }

  void setWidth(double w) {
    Box::width = w;
  }
};
// Main function for the program
int main() {
  Box box;

  // set box length without member function
  box.length = 10.0; // OK: because length is public
  cout << "Length of box : " << box.length <<endl;

  // set box width without member function
  // box.width = 10.0; // Error: because width is private
  box.setWidth(10.0);  // Use member function to set it.
  cout << "Width of box : " << box.getWidth() <<endl;

  return 0;
}
