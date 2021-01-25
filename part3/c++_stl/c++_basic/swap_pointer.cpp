
// 函数定义交换值

void swap(int *x, int *y) {
  int temp = *x; // save the value at address x
  *x = *y;
  *y = temp;
}