# Update the blanks below to solve the problem

t = int(input())
for i in range(t):
    n = int(input())
    A = list(map(int, input().split()))
    #Unique elements of A using Set()
    #* is used in the syntax as we want only the values - print without the '*' to check the output
    print(*set(A))