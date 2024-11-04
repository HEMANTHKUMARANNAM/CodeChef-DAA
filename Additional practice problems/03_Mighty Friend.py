# cook your dish here

import heapq

t = int(input())

for _ in range(t):
    
    s = list( map( int , input().split() ) )
    
    a = list( map( int , input().split() ) )
    
    motu = []
    
    tomu = []
    
    for i in range(len(a)):
        
        if( i%2 == 0 ):
            motu.append( -a[i] )
        else:
            tomu.append( a[i] )
            
    heapq.heapify(motu)
    heapq.heapify(tomu)
    
    for _ in range(s[1]):
        
        temp = heapq.heappop(motu)
        meow = heapq.heappop(tomu)
        
        heapq.heappush( motu , -meow  )
        heapq.heappush( tomu , -temp )
        
    
    
    
    
    ms = -sum(motu)
    ts = sum(tomu)
    
    if( ts > ms ):
        print("YES")
    else:
        print("NO")
    
    