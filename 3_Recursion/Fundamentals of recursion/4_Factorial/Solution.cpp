#include <iostream>
using namespace std;

int Factorial(int n) {
    // Write your code here
    
    if(n==0)
    {
        return 1;
    }
    
    return n*Factorial(n-1);
    
}

int main() {
    int n;
    cin >> n;
    cout << Factorial(n) << endl;
    return 0;
}
