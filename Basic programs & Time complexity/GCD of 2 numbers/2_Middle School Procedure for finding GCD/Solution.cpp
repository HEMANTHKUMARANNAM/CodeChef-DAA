#include <iostream>
#include <algorithm>

// Solution as follows
std::vector<int> prime_factors(int n) {
    std::vector<int> factors;
    for (int d = 2; n > 1; d++) {
        while (n % d == 0) {
            factors.push_back(d);
            n /= d;
        }
        if (d * d > n) {
            if (n > 1) factors.push_back(n);
            break;
        }
    }
    return factors;
}

int gcd_middle_school(int a, int b) {
    std::vector<int> factors_a = prime_factors(a);
    std::vector<int> factors_b = prime_factors(b);
    
    int gcd = 1;
    size_t i = 0, j = 0;
    while (i < factors_a.size() && j < factors_b.size()) {
        if (factors_a[i] == factors_b[j]) {
            gcd *= factors_a[i];
            i++;
            j++;
        } else if (factors_a[i] < factors_b[j]) {
            i++;
        } else {
            j++;
        }
    }
    return gcd;
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
        int result = gcd_middle_school(a, b);
        std::cout << result << std::endl;
    }
    
    return 0;
}