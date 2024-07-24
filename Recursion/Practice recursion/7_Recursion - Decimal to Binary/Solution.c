#include <stdio.h>

long Binary(int n) 
{
    //Write your code here
    
    if(n ==0)
    {
        return 0;
    }
    
    if( n%2 ==0 )
    {
        return Binary(n/2)*10 + 0;
    }
    
    return Binary(n/2)*10 + 1;
    
    
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%ld",Binary(n) );;
    return 0;
}
