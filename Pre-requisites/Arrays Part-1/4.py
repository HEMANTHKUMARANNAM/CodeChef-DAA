# Update the blanks in the code below to solve the problem

t = int(input())
for i in range(t):
    A = list(map(int,input().split()))
    
    #Calculate and store Team-1 and Team-2 scores
    team1 = A[0] + A[2] + A[4] + A[6] + A[8]
    team2 = A[1] + A[3] + A[5] + A[7] + A[9]
    
    #Apply relevant conditions to check for victory
    if team1 > team2:
        print(1)
    elif team1 < team2:
        print(2)
    else:
        print(0)
    