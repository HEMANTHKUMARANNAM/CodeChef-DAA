# cook your dish here


t = int(input())

for _ in range(t):
    n = int(input())
    
    l = list( map( int , input().split() ) )
    
    mymap = {}
    
    for i in l:
        
        mymap[i] = mymap.get(i , 0) +1
        
    maxval =0
        
    for val in mymap.values():
        maxval = max( maxval , val )
    
    if( maxval == 1 and n >1 ):
        print( n-2 )
        continue
    
    print(n-maxval)
        
        
        