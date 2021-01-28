#include <iostream>

using namespace std;

class Box {
protected:
  double width;
};

class SmallBox : Box {
public:
  void setSmallWidth(double width);

  double getSmallWidth();
};

void SmallBox::setSmallWidth(double w) {
  width = w;
}

double SmallBox::getSmallWidth() {
  return width;
}

// Main function for the program
int main() {
  SmallBox box;

  // set box width using member function
  box.setSmallWidth(5.0);
  cout << "Width of box : "<< box.getSmallWidth() << endl;

  return 0;
}
