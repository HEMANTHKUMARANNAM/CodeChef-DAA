# Solution as follows

def gcd_euclid(a, b):
    while b:
        a, b = b, a % b
    return a
    
# Get test cases 't'
t = int(input())

for _ in range(t):
    # Get user input
    a, b = map(int, input().split())
    
    # Calculate and print the GCD
    result = gcd_euclid(a, b)
    print(result)