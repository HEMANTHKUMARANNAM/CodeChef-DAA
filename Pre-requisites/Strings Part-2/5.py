# Update the code below to solve the problem

t = int(input())
for i in range(t):
    X = int(input())
    S = input()
    
    c = 0
    n = 0
    
    d =0
    
    for i in S :
        if(i == 'N'):
            n = n+2
            
        if(i == 'C'):
            c = c+2
            
        if(i == 'D'):
            d = d+1
            
    if( c== n ):
        print( 55*X )
    elif( c > n ) :
        print( 60*X )
    else:
        print(40 *X)
    
    
