# Solution as follows

t = int(input())
for i in range(t):
    N = int(input())
    A = list(map(int, input().split()))
    
    # Weekend holiday dates
    weekend = [6, 7, 13, 14, 20, 21, 27, 28]    
    
    #merging the list of holidays  
    overall = A + weekend        
    #finding the unique list after removing duplicates
    overall_unique = list(set(overall))     
    # number of elements in the final holiday list
    print(len(overall_unique))      