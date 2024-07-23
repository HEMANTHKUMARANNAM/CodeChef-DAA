# update the function below

def gcd_brute_force(a, b):
    # Find the smaller of the two numbers
    
    m = min(a,b)


    # Start from the smaller number and work our way down
    
    for i in range(m,1,-1):
        if(a%i==0 and b%i==0):
            return i
            
    return 1



# Get test cases 't'
t = int(input())

for _ in range(t):
    # Get user input
    a, b = map(int, input().split())
    
    # Calculate and print the GCD
    result = gcd_brute_force(a, b)
    print(result)