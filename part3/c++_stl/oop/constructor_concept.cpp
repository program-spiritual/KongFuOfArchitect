#include <iostream>

using namespace std;

class Line{
public:
  void setLength(double len){
    length = len;
  };

  double getLength() {
    return length;
  }

  Line() {
    cout << "Object is being created" << endl;
  }

private:
  double length;
};



int main(){
  Line line;
// set line length
  line.setLength(6.0);
  cout << "Length of line : " << line.getLength() <<endl;

}