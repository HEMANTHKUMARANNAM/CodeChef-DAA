def longestPalindromicSubsequence(S):
    n = len(S)
    
    # Create a 2D DP array
    dp = [[0] * n for _ in range(n)]
    
    # Every single character is a palindrome of length 1
    for i in range(n):
        dp[i][i] = 1
    
    # Fill the DP table
    for length in range(2, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            
            if S[i] == S[j]:
                dp[i][j] = dp[i + 1][j - 1] + 2
            else:
                dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
    
    # Result is the length of the longest palindromic subsequence in the entire string
    return dp[0][n - 1]

def main():
    S = input()
    result = longestPalindromicSubsequence(S)
    print(result)

if __name__ == "__main__":
    main()
