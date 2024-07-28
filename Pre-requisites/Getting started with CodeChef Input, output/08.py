# Update the '_' below to solve the problem

#accept the count of test cases given in the the 1st line
t = int(input())       
#run a loop to accept 't' inputs
for i in range(t):     
    #accept 2 integers on the 1st line of each test case
    A, B = map(int, input().split() )      
    #accept 3 integers on the 2nd line of each test case
    C, D, E = map(int, input().split() )   
    #output the 5 integers on a single line for each test case    
    print(A, B, C, D, E)