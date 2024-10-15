#include <iostream>
#include <algorithm>

// Solution as follows
int gcd_euclid(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    int t;
    // Get test cases 't'
    std::cin >> t;
    
    for (int i = 0; i < t; i++) {
        int a, b;
        // Get user input
        std::cin >> a >> b;
        
        // Calculate and print the GCD
        int result = gcd_euclid(a, b);
        std::cout << result << std::endl;
    }
    
    return 0;
}