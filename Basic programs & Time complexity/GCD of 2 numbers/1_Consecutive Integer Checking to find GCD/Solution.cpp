#include <iostream>
#include <algorithm>

// Solution as follows
int gcd_brute_force(int a, int b) {
    // Find the smaller of the two numbers
    
    int min;
    
    if(a>b)
    {
        min = b;
    }
    else
    {
        min= a; 
    }




    // Start from smaller and work our way down
    
    
    for(int i = min ; i>1; i--)
    {
        if(a%i==0 && b%i==0)
        {
            return i;
        }
    }





    
    // This line should never be reached for positive integers
    return 1;
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
        int result = gcd_brute_force(a, b);
        std::cout << result << std::endl;
    }
    
    return 0;
}