# cook your dish here

def expression(opp, val):
    # condition check
    if( val > opp +1 or val < -opp+1 ):
        return "-1"
        
    if val == 1 :
        return "*"*opp
    if val == 0:
        return "-" + "*"*(opp-1)
    
    if val > 1 :
        mul = val-1
        return "+"*mul + "*"*(opp-mul)
        return
    if val <=-1:
        mul = -val + 1
        return "-"*mul + "*"*(opp-mul)
        
    
        
    




t = int(input())
for _ in range(t):
    opperations , val = map(int , input().split() )
    print(expression(opperations,val))