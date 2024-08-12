# Update the functions below

def int_to_binary(n):
    if(n==0):
        return 0
        
    if( n%2 ==1 ):
        return int_to_binary(n//2)*10 + 1
        
    return int_to_binary(n//2)*10 + 0





def count_binary_digits(n):
    
    if(n ==0):
        return 0
    
    return 1 + count_binary_digits(n//2)



# Read the number of test cases
T = int(input())

# Process each test case
for _ in range(T):
    N = int(input())
    binary = int_to_binary(N)
    digit_count = count_binary_digits(N)
    print(digit_count)