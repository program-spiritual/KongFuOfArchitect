#include <iostream>

using namespace std;

class Shape {
protected:
  int width, height;

public:
  explicit Shape(int a = 0, int b = 0) {
    width = a;
    height = b;
  }

  virtual int area(){
      cout << "Parent class area :" <<endl;
      return 0;
  };
};

class Rectangle : public Shape {
public:
  explicit Rectangle(int a = 0, int b = 0) : Shape(a, b) {}

  int area() override {
    cout << "Rectangle class area :" << endl;
    return (width * height);
  }
};

class Triangle : public Shape {
public:
  explicit Triangle(int a = 0, int b = 0) : Shape(a, b) {}

  int area() override {
    cout << "Triangle class area :" << endl;
    return (width * height / 2);
  }
};

// Main function for the program
int main() {
  Shape *shape;
  Rectangle rec(10, 7);
  Triangle tri(10, 5);

  // store the address of Rectangle
  shape = &rec;

  // call rectangle area.
  shape->area();

  // store the address of Triangle
  shape = &tri;

  // call triangle area.
  shape->area();


  return 0;
}
