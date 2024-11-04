# cook your dish here


t = int(input())

for _ in range(t):
    
    s = int(input())
    
    if(s==3):
        print("1 2 3")
        continue
    
    a =[]
    
    a= a+ [s , s-2]
    
    for i in range(1 , s-3 ):
        a.append(i)
    
    a = a+ [s-3 , s-1] 
    
    print(*a)
    
    
    
    
    
    
    
    
    