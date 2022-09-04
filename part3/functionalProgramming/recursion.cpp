#include <stdio.h>
long int fact(int n);

int main() {
    int n;
    printf("输入正整数: ");
    scanf("%d", &n);
    printf("Factorial of %d = %ld", n, fact(n));
    return 0;
}
long int fact(int n) {
    if (n >= 1)
        return n*fact(n-1);
    else
        return 1;
}
