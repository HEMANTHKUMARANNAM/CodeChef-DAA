def myfun(n, colors):
    
    t = colors.count(n)
    
    meow = [ data for data in colors if data != n ]
    

    tn = len(colors)-t
    
    ratio = sum(meow)/(n)
    

    if( ratio >= tn-1  ):
        t += sum(meow)- (tn-1)*n
        
        print( sum(meow)- (tn-1)*n  )
        
    else:
        print(0)
    

t = int(input())
for _ in range(t):
    boxes, cc = map(int, input().split())
    colors = list(map(int, input().split()))
    myfun(boxes, colors)
