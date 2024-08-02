
def print_pattern(n):
    #Write your code here
    
    for i in range(n):
        for j in range(n):
            if(i<=j):
                print("*" , end = "")
            
        print("")

n = int(input())
print_pattern(n)