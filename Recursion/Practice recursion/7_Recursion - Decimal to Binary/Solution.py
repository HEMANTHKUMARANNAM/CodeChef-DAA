def Binary(n):
    #Write your code here
    if( n ==0 ):
        return ""
        
    if( n%2 ==0 ):
        return Binary(n//2)+ "0"
        
    return Binary(n//2) + "1"

n = int(input())
print(Binary(n))