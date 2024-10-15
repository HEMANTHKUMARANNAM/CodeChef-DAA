# cook your dish here


def upperbound(a , key):
    left =0
    right = len(a)
    
    while( right > left ):
        
        mid = (right+left)//2
        
        if( a[mid] <= key ):
            
            left = mid +1
            
        else :
            right = mid
            
            
    return left
            


t = int(input())

for _ in range(t):
    n = int(input())
    a = list( map( int , input().split()))
    a.sort()
    count =0
    for i in range(n):
        index = upperbound(a,a[i])
        if( index > n-index  ):
            count = count+1
            
    print(count)
    
        