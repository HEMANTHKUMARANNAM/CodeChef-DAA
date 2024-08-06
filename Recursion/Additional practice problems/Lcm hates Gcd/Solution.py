# cook your dish here


def gcd(a , b):
    if( b==0 ):
        return a
    
    return  gcd( b , a%b )
    

def lcm(a,b):
    return a*b//gcd(a,b)
    
    
def minfun(a,b):
    
    x = gcd(a,b)
    
    return lcm(a,x)-gcd(b,x)
    

t = int(input())

for _ in range(t):
    
    a,b = map(int , input().split() )
    
    print( minfun(a,b) )