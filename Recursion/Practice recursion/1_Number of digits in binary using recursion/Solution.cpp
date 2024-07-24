#include <iostream>
#include <string>

std::string int_to_binary(int n) {
    if (n == 0) return "0";
    std::string binary = "";
    while (n > 0) {
        binary = std::to_string(n % 2) + binary;
        n /= 2;
    }
    return binary;
}

// Update the function below
int count_binary_digits(int n) {
    
    if(n==0)
    {
        return 0;
    }
    
    return 1+count_binary_digits(n/2);

    
}

int main() {
    int T;
    std::cin >> T;
    
    for (int i = 0; i < T; i++) {
        int N;
        std::cin >> N;
        std::string binary = int_to_binary(N);
        int digit_count = count_binary_digits(N);
        std::cout << digit_count << std::endl;
    }
    
    return 0;
}
