#include <iostream>
using namespace std;

int sum(int n) {
    cout << "Sum(" << n << ") is called" << endl;
    if (n == 1) {
        cout << "Base Condition reached" << endl;
        return 1;
    }
    int sumN1 = sum(n - 1);
    cout << "Sum(" << n << ") = " << n << " + Sum(" << n - 1 << ")" << endl;
    int sumN = n + sumN1;
    cout << "Sum(" << n << ") = " << n << " + " << sumN1 << endl;
    cout << "Sum(" << n << ") is returning " << sumN << endl;
    return sumN;
}

int main() {
    cout << "Sum of first 5 natural numbers is " << sum(5) << endl;
    return 0;
}
