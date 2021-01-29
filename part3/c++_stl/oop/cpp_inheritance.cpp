#include <iostream>

using namespace std;

class Shape {
public:
  int getWidth() const {
    return width;
  }

  void setWidth(int w) {
    width = w;
  }

  int getHeight() const {
    return height;
  }

  void setHeight(int h) {
    height = h;
  }

protected:
  int width;
  int height;
};

class Rectangle : public Shape {
public:
  int getArea() {
    return (width * height);
  }
};

int main() {
  Rectangle Rect;

  Rect.setWidth(5);
  Rect.setHeight(7);

  // Print the area of the object.
  cout << "Total area: " << Rect.getArea() << endl;

  return 0;
}