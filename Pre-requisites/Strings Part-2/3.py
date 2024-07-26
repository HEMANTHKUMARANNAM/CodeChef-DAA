# Update the code below to solve the problem

t = int(input())
for i in range(t):
    S = input()
    T = input()
    
    ans = ""
    
    for i,j in zip(S,T):
        if i == j:
            ans = ans + "G"
        else :
            ans = ans + "B"
            
    print(ans)