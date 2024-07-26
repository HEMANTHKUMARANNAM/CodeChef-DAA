# Update the code below to solve the problem
t = int(input())
for i in range(t):
    N = int(input())
    A = list(map(int, input().split()))
    #highest element of the list
    highest = max(A)
    #smallest element of the list
    smallest = min(A)
    #sum of all the elements of the list
    total = sum(A)
    print(highest, smallest, total)