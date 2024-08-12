# Update the '_' in the code below to solve this problem

t = int(input())
for i in range(t):
    #Treat A as a string instead of an integer
    A = input()   
    
    flag = 0
    
    for i in A:
        #If any '0' or '5' is found in the string A - then set flag as 1 and exit the loop
        if i == '0' or i == '5' :
            flag = 1
            break       
    
    if flag == 1:
        print('Yes')
    else:
        print('No')
        