# this code has some logical error - debug this code to solve the problem

t = int(input())
for i in range(t):
    n = int(input())
    A = list(map(int,input().split()))
    
    count_neg = 0
    count_zero = A.count(0)
    
    if count_zero > 0:
        print(0)
    else:
        i = 0
        while i<n:
            if A[i] < 0:
                count_neg = count_neg + 1
            i = i + 1
        
        if count_neg%2 != 0:
            print(1)
            
        else :
            print(0)