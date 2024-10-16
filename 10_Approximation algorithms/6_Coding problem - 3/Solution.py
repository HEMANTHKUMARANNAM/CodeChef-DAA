t = int(input())  

for _ in range(t):
    n = int(input())  
    c = list(map(int, input().split()))  
    print( n - max(c) )


