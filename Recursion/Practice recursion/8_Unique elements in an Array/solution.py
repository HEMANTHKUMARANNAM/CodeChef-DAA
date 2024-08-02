def find_unique_recursive(arr, index=0, unique_set=None):
    if unique_set is None:
        unique_set = set()
    if index == len(arr):
        return sorted(unique_set)
        
    unique_set.add(arr[index])
    
    return find_unique_recursive(arr, index + 1, unique_set)





# accept test cases
t = int(input())
for _ in range(t):
    # Input
    n = int(input())
    arr = list(map(int, input().split()))
    
    # Find unique elements
    unique_elements = find_unique_recursive(arr)
    
    # Output
    print(*unique_elements)