#include <iostream>
using namespace std;

string checkPalindrome(string s, int n) {
    //Write your code here
    if( n == s.length()  )
    {
        return "YES";
    }
    
    if( s[n] == s[ s.length()-1-n ] )
    {
        return checkPalindrome(s,n+1);
    }
    
    return "NO";
    
    
}

int main() {
    string s;
    cin >> s;
    cout << checkPalindrome(s, 0) << endl;
    return 0;
}
