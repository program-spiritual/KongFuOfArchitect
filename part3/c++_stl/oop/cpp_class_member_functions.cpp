#include <iostream>

using namespace std;

class Box {
public:
  double length;
  double breadth;
  double height;

//  成员函数声明
  double getVolume() const;

  void setLength(double length);

  void setBreadth(double breadth) ;

  void setHeight(double height);
};
// 成员函数定义
double Box::getVolume() const {
  return length * breadth * height;
}

void Box::setLength(double len) {
  length = len;
}

void Box::setBreadth(double bre) {
  breadth = bre;
}

void Box::setHeight(double hei) {
  height = hei;
}

int main(){
  Box Box1{};                // Declare Box1 of type Box
  Box Box2{};                // Declare Box2 of type Box
  double volume = 0.0;     // Store the volume of a box here

  // box 1 specification
  Box1.setLength(6.0);
  Box1.setBreadth(7.0);
  Box1.setHeight(5.0);

  // box 2 specification
  Box2.setLength(12.0);
  Box2.setBreadth(13.0);
  Box2.setHeight(10.0);

  // volume of box 1
  volume = Box1.getVolume();
  cout << "Volume of Box1 : " << volume <<endl;

  // volume of box 2
  volume = Box2.getVolume();
  cout << "Volume of Box2 : " << volume <<endl;
  return 0;
}