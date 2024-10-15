def prime_factors(n):
    factors = []
    d = 2
    while n > 1:
        while n % d == 0:
            factors.append(d)
            n //= d
        d += 1
        if d * d > n:
            if n > 1:
                factors.append(n)
            break
    return factors

# Solution as follows
def gcd_middle_school(a, b):
    factors_a = prime_factors(a)
    factors_b = prime_factors(b)
    
    gcd = 1
    i, j = 0, 0
    while i < len(factors_a) and j < len(factors_b):
        if factors_a[i] == factors_b[j]:
            gcd = gcd * factors_a[i]
            i += 1
            j += 1
        elif factors_a[i] < factors_b[j]:
            i += 1
        else:
            j += 1
    
    return gcd

t = int(input())
for _ in range(t):
    a, b = map(int, input().split())
    result = gcd_middle_school(a, b)
    print(result)