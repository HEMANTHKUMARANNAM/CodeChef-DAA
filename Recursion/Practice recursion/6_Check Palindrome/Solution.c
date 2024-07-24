#include <stdio.h>
#include <string.h>

char* checkPalindrome(char* s, int n) {
    //Write your code here
    
    if( n == strlen(s) )
    {
        return "YES";
    }
    
    if( s[n] == s[strlen(s)-1-n] )
    {
        return checkPalindrome(s,n+1);
    }
    
    return "NO";
    
    
}

int main() {
    char s[100];
    scanf("%s", s);
    printf("%s\n", checkPalindrome(s, 0));
    return 0;
}
