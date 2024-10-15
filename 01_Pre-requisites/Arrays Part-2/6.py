# Update the blanks below to solve the problem

t = int(input())
for i in range(t):
    n = int(input())
    A = list(map(int, input().split()))
    #Unique elements of A using Set()
    print(*set(A))
    
    #Create an empty list to store frequency of elements in A
    frequency = []
    for i in set(A):
        #count the occurence of element 'i' in A
        count = A.count(i)
        #append the count of 'i' to the frequency list
        frequency.append(count)
    #print the occurence of each element in A
    print(*frequency)