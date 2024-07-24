#include <iostream>
using namespace std;

string Binary(int n) {
    //Write your code here
    if( n ==0 )
    {
        return "";
    }
    
    if( n%2 ==0 )
    {
        return Binary(n/2) + "0";
    }
    
    return Binary(n/2) + "1";
    
    
}

int main() {
    int n;
    cin >> n;
    cout << Binary(n) << endl;
    return 0;
}
