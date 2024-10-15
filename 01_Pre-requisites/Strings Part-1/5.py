# Update the code below to solve the problem

t = int(input())
for i in range(t):
    N = int(input())
    S = input()
    ans =0
    for i in range( N-1 ):
        if( S[i] == S[i+1] ):
            ans = ans +1
            
    print(ans)
            
    
    
    