# cook your dish here

def apples(app , box):
    if( box == 1 ):
        return "NO"
    
    if( (app//box)%box == 0 ):
        return "NO"
        
    return "YES"
    


t = int(input())


for _ in range(t):
    
    app , box = map(int , input().split(" ") )
    
    print( apples(app , box) )

