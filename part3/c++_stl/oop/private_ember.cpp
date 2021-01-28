#include <iostream>

class Box {
  double width;
public:
  double length;

  void setWidth(double wid);

  double getWidth() const;
};

void Box::setWidth(double wid) {
  this->width = wid;
}

double Box::getWidth() const {
  return width;
}
