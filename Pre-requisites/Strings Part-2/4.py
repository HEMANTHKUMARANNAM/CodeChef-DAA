# Update the code below to solve the problem

t = int(input())
for i in range(t):
    S = input()
    
    flag = False
    
    v = "aeiou"
    
    for i in range(len(S)-2):
        if(S[i] in v and S[i+1] in v and S[i+2] in v  ):
            flag = True
            
    if(flag):
        print("HAPPY")
        
    else:
        print("SAD")