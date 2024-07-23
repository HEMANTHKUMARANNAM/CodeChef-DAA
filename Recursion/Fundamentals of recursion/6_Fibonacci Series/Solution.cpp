#include <iostream>
using namespace std;

int fib(int n) {
    //Write your code here
    if(n==1)
        {
            return 0;
        }
        if(n==2)
        {
            return 1;
        }
        
        return fib(n-1)+ fib(n-2);
}

int main() {
    int n;
    cin >> n;
    cout << fib(n) << endl;
    return 0;
}
