# cook your dish here


t = int(input())

for _ in range(t):
    
    mean , median = map(int , input().split(" ") )
    
    print( 3*mean-2*median , median , median  )