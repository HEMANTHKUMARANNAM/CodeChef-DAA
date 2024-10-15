# cook your dish here

def combinations(arr):
    ans =0
    
    for j in range(len(arr[0])):
        n =0
        for i in range(len(arr)):
            if( arr[i][j] == 1 ):
                n += 1
        ans += n*(n-1)//2  
        
    return ans
        
                
            


t = int(input())

for _ in range(t):
    
    r,c = map( int , input().split(" ") )
    
    arr = []
    
    for _ in range(r):
        l = input()
        l = [ int(c) for c in l ]
        arr.append(l)
        
    print( combinations(arr) )
        
        




































