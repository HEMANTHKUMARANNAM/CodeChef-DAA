#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* int_to_binary(int n) {
    if (n == 0) return "0";
    char* binary = malloc(33 * sizeof(char));  // Max 32 bits + null terminator
    binary[32] = '\0';
    int index = 31;
    while (n > 0) {
        binary[index--] = (n % 2) + '0';
        n /= 2;
    }
    return &binary[index + 1];
}

// Update the function below
int count_binary_digits(int n) {
    
    if(n==0)
    {
        return 0;
    }
    
    return 1+ count_binary_digits(n/2);
    
}

int main() {
    int T;
    scanf("%d", &T);
    
    for (int i = 0; i < T; i++) {
        int N;
        scanf("%d", &N);
        char* binary = int_to_binary(N);
        int digit_count = count_binary_digits(N);
        printf("%d\n", digit_count);
    }
    
    return 0;
}