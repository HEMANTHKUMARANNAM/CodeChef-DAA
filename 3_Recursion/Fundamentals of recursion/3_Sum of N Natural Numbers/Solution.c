#include <stdio.h>

int sum(int n) {
    printf("Sum(%d) is called\n", n);
    if (n == 1) {
        printf("Base Condition reached\n");
        return 1;
    }
    int sumN1 = sum(n - 1);
    printf("Sum(%d) = %d + Sum(%d)\n", n, n, n - 1);
    int sumN = n + sumN1;
    printf("Sum(%d) = %d + %d\n", n, n, sumN1);
    printf("Sum(%d) is returning %d\n", n, sumN);
    return sumN;
}

int main() {
    printf("Sum of first 5 natural numbers is %d\n", sum(5));
    return 0;
}
