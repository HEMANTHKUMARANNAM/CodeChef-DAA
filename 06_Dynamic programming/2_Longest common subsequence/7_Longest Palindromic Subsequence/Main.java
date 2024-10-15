import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading input
        String S = scanner.nextLine();
        int n = S.length();
        
        // Call the function to find the length of the longest palindromic subsequence
        int result = longestPalindromicSubsequence(S, n);
        
        // Output the result
        System.out.println(result);
        
        scanner.close();
    }
    
    public static int longestPalindromicSubsequence(String S, int n) {
        // Create a 2D DP array
        int[][] dp = new int[n][n];
        
        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Fill the DP table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                
                if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Result is the length of the longest palindromic subsequence in the entire string
        return dp[0][n - 1];
    }
}
