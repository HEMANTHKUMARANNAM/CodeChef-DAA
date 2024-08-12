# cook your dish here
import heapq


def maxtaste(mp):
    
    val = list(mp.values())
    
    values = [ -v for v in val ]
    
    heapq.heapify(values)
    
    max1 = -heapq.heappop(values)
    max2 = -heapq.heappop(values)
    
    return max1 + max2
    

t = int(input())

for _ in range(t):
    
    l,d = map(int ,input().split() )
    
    mp = {}
    
    for _ in range(l):
        k,v = map(int , input().split())
        
        if k in mp:
            mp[k] = max(mp[k] , v)
        else:
            mp[k] = v
            
    
    print(maxtaste(mp))
    