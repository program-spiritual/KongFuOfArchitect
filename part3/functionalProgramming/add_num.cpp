#include <stdio.h>
int addNum(int a, int b);     // function prototype
int main() {
    int sum;
    sum = addNum(5,6);         // function call
    printf("sum = %d",sum);
    return 0;
}
int addNum (int a,int b) {    // function definition
    int result;
    result = a + b;
    return result;             // return statement
}
