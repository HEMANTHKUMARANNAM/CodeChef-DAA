def backtrack(nums, path, used, res):
    if len(path) == len(nums):
        res.append(path[:])
        return
    
    for i in range(len(nums)):
        if used[i] or (i > 0 and nums[i] == nums[i-1] and not used[i-1]):
            continue
        
        used[i] = True
        path.append(nums[i])
        backtrack(nums, path, used, res)
        path.pop()
        used[i] = False

def find_unique_permutations(A):
    A.sort()
    res = []
    used = [False] * len(A)
    backtrack(A, [], used, res)
    return res

# Driver code
T = int(input())
for _ in range(T):
    N = int(input())
    A = list(map(int, input().split()))
    unique_permutations = find_unique_permutations(A)
    
    print(len(unique_permutations))
    for perm in unique_permutations:
        print(" ".join(map(str, perm)))
