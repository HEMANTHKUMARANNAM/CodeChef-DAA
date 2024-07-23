def Sum(n):
    print(f"Sum({n}) is called")
    if n==1:
        print("Base Condition reached")
        return 1
    sumN1 = Sum(n-1)
    print(f"Sum({n}) = {n} + Sum({n-1})")
    
    sumN = n + sumN1
    print(f"Sum({n}) = {n} + {sumN1}")
    
    print(f"Sum({n}) is returning {sumN}")
    return sumN
    
print("Sum of first 5 natural numbers is", Sum(5))