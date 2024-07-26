# Update the '_' in the code below to solve the problem

t = int(input())
for i in range(t):
    N, k = map(int, input().split())
    A = list(map(int, input().split()))
    
    #Declare and initialise variables - pos, neg and divk
    #Note that we are reinitializing the variables to be 0 for each test case.
    pos = 0
    neg = 0
    divk = 0
    
    i = 0
    #Loop through all elements of the array
    while i < len(A):
        #Count the negative elements of the array
        if A[i]< 0:
            neg = neg + 1
        #Count the positive elements of the array
        elif A[i] > 0:
            pos = pos + 1
        #Count if the given element is divisible by k
        if A[i]%k == 0:
            divk = divk + 1
        i = i + 1
    
    print(pos,neg,divk)