# Solution as follows

t = int(input())
for i in range(t):
    X = int(input())
    S = input()
    
    #variables to store Carlsen's and Chef's score
    carlsen = 0
    chef = 0
    
    i = 0
    while i < 14:
        #loop through the string to identify the winner of each match
        if S[i] == 'C':
            carlsen = carlsen + 2
        elif S[i] == 'N':
            chef = chef + 2
        else:
            carlsen = carlsen + 1
            chef = chef + 1
        i = i + 1
       
    #conditions to check amount won by Carlsen
    carlsen_amount = 0 
    if carlsen > chef:
        carlsen_amount = 60*X
    elif chef > carlsen:
        carlsen_amount = 40*X
    else:
        carlsen_amount = 55*X
        
    print(carlsen_amount)
