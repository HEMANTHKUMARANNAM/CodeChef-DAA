def can_form_subset(A, X):
    # DP array to store if a sum j is possible
    dp = [False] * (X + 1)
    dp[0] = True  # Base case: sum of 0 is always possible

    # Process each element in the array
    for num in A:
        # Update the DP table in reverse to prevent overwriting
        for j in range(X, num - 1, -1):
            if dp[j - num]:
                dp[j] = True

    # Result is whether we can form the sum X
    return dp[X]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    X = int(data[1])
    A = list(map(int, data[2:2+N]))

    if can_form_subset(A, X):
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()
