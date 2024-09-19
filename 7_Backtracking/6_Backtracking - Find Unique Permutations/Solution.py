from itertools import permutations

def unique_permutations(arr):
    perm = set(permutations(arr))
    return sorted(perm)


T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int, input().split()))
    
    result = unique_permutations(arr)
    
    print(len(result))
    
    for perm in result:
        print(" ".join(map(str, perm)))

