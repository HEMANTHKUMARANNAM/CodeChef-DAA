#include <stdio.h>

// Solution as follows
int gcd_euclid(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    int t;
    // Get test cases 't'
    scanf("%d", &t);
    
    for (int i = 0; i < t; i++) {
        int a, b;
        // Get user input
        scanf("%d %d", &a, &b);
        
        // Calculate and print the GCD
        int result = gcd_euclid(a, b);
        printf("%d\n", result);
    }
    
    return 0;
}