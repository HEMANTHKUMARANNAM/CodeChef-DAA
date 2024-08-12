# Update the '_' in the code below to solve this problem

t = int(input())
for i in range(t):
    A = input()
    B = input()
    
    #variable to store the count of '1's in A and B and the count of indices where A[i] = B[i]
    a_count = 0         
    b_count = 0 
    common = 0 
    
    # Count '1s' in A
    for i in A:
        if i == '1' :
            a_count = a_count + 1

    # Count '1s' in B
    for i in B:
        if i == '1' :
            b_count = b_count + 1

    # Count indices where A[j] = B[j]    
    j = 0
    n = len(A)
    while j<n:
        if A[j] == B[j]:
            common = common + 1
        j = j + 1
    
    print(a_count,b_count,common)