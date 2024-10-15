# cook your dish here

t = int(input())

for _ in range(t):
    n = int(input())
    b = list( map( int , input().split() ) )
    g = list( map( int , input().split() ) )
    
    b.sort()
    
    g.sort( reverse = True )
    
    lv = []

   
    for i in range(0 , len(b)):
        
        lv.append( b[i]+ g[i] )

    print( max(lv) )
    