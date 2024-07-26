# Update the blanks below to solve the problem

t = int(input())
for i in range(t):
    N, X = map(int, input().split())
    A = list(map(int, input().split()))
    #variable to store the count of X
    occurrence = A.count(X)
    #variable to store the position / index of X
    index = A.index(X)
    print(occurrence, index)