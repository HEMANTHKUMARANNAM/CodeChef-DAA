def backtrack(idx, a, x, subset, ans):
    if idx == len(a):
        # Write your code here
        
        if( sum(subset) == x ):
            ans.append(subset[:])

        return

    backtrack(idx + 1, a, x, subset, ans)  # Don't take the i-th integer

    subset.append(a[idx])
    backtrack(idx + 1, a, x, subset, ans)  # Take the i-th integer
    subset.pop()

def subset_sum(a, x):
    subset = []  # Creating an empty subset
    ans = []  # To store all the subsets

    backtrack(0, a, x, subset, ans)

    return ans

if __name__ == "__main__":
    n, x = map(int, input().split())
    a = list(map(int, input().split()))

    subsets = subset_sum(a, x)
    subsets = [sorted(subset) for subset in subsets]
    subsets.sort()

    for subset in subsets:
        print(*subset)
