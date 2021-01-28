#include <iostream>
using namespace std;
class Line{
public:
  double getLength() const;

  void setLength(double length);

public:
  double length;
};

double Line::getLength() const {
  return length;
}

void Line::setLength(double len) {
  Line::length = len;
}

int main(){
  Line line;
  line.setLength(100);
  cout << "Length of line : " << line.getLength() <<endl;

  // set line length without member function
  line.length = 10.0; // OK: because length is public
  cout << "Length of line : " << line.length <<endl;

}