#include <iostream>

using namespace std;

class Time{
private:
  int hours;
  int minutes;
public:
  Time(){
    hours=0;
    minutes = 0;
  }
  Time(int h, int m) {
    hours = h;
    minutes = m;
  }
  void displayTime() const {
    cout << "H: " << hours << " M:" << minutes <<endl;
  }

//  重载前缀++运算符
  Time operator++ () {
    ++minutes;          // increment this object
    if(minutes >= 60) {
      ++hours;
      minutes -= 60;
    }
    return {hours, minutes};
  }
// 后缀运算符
   Time operator++( int ) {

    // save the orignal value
    Time T(hours, minutes);

    // increment this object
    ++minutes;

    if(minutes >= 60) {
      ++hours;
      minutes -= 60;
    }

    // return old original value
    return T;
  }
};

int main(){
  Time T1(11, 59), T2(10,40);

  ++T1;                    // increment T1
  T1.displayTime();        // display T1
  ++T1;                    // increment T1 again
  T1.displayTime();        // display T1

  T2++;                    // increment T2
  T2.displayTime();        // display T2
  T2++;                    // increment T2 again
  T2.displayTime();        // display T2
  return 0;
}
