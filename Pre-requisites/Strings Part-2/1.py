# Update the '_' below to solve this problem

t = int(input())
for _ in range(t):
    S = input()
    A = []
    
    for i in S:
        #Converts a character into its ASCII value
        A.append(ord(i))    
    
    print(*A)