# Update the blanks in the code below to solve the problem

t = int(input())
for i in range(t):
    N, X = map(int, input().split())
    A = list(map(int, input().split()))
    #We need to remove the element at the Xth position
    #Python lists are 0 indexed
    del A[X-1]
    #print only the N-1 space separated integers - not the list
    print(*A)