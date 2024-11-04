# cook your dish here

import heapq


t = int(input())


for _ in range(t):
    
    count = 0
    
    maxval = 0
    
    s = int(input())
    
    a = list( map( int , input().split() ) )
    
    v = list( map( int , input().split() ) )
    
    heapq.heapify(a)
    
    heapq.heapify(v)
    
    
    while a and v:
        
        if( a[0] < v[0] ):
            count+=1
            heapq.heappop(a)
        elif( a[0] > v[0] ):
            count-=1;
            heapq.heappop(v)
        else:
            heapq.heappop(a)
            heapq.heappop(v)
        
        maxval = max( maxval , count )
        
    print(maxval)
        
        
    
    