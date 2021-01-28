#include <iostream>

using namespace std;

class Line {
public:
  void setLength( double len );
  double getLength( ) const;
  Line();   // This is the constructor declaration
  ~Line();  // This is the destructor: declaration

private:
  double length;
};

// Member functions definitions including constructor
Line::Line() {
  cout << "Object is being created" << endl;
}
Line::~Line() {
  cout << "Object is being deleted" << endl;
}
void Line::setLength( double len ) {
  length = len;
}
double Line::getLength( ) const {
  return length;
}

// Main function for the program
int main() {
  Line line;

  // set line length
  line.setLength(6.0);
  cout << "Length of line : " << line.getLength() <<endl;

  return 0;
}
