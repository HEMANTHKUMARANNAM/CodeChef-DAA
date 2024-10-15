#include <stdio.h>
#include <stdlib.h>

void prime_factors(int n, int* factors, int* size) {
    *size = 0;
    for (int d = 2; n > 1; d++) {
        while (n % d == 0) {
            factors[(*size)++] = d;
            n /= d;
        }
        if (d * d > n) {
            if (n > 1) factors[(*size)++] = n;
            break;
        }
    }
}

// Solution as follows
int gcd_middle_school(int a, int b) {
    int factors_a[100], factors_b[100], size_a, size_b;
    prime_factors(a, factors_a, &size_a);
    prime_factors(b, factors_b, &size_b);
    
    int gcd = 1, i = 0, j = 0;
    while (i < size_a && j < size_b) {
        if (factors_a[i] == factors_b[j]) {
            gcd *= factors_a[i];
            i++;
            j++;
        } else if (factors_a[i] < factors_b[j]) {
            i++;
        } else {
            j++;
        }
    }
    return gcd;
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
        int result = gcd_middle_school(a, b);
        printf("%d\n", result);
    }
    
    return 0;
}