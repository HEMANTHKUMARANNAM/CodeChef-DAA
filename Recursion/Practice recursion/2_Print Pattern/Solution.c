#include <stdio.h>

void print_pattern(int n) {
    //Write your code here
    if(n==0)
    {
        return;
    }
    
    for(int i =0 ; i< n ; i++)
    {
        printf("*");
    }
    printf("\n");
    
    print_pattern(n-1);
}

int main() {
    int n;
    scanf("%d", &n);
    print_pattern(n);
    return 0;
}
