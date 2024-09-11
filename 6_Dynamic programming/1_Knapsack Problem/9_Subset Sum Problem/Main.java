import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Reading input
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // Call the function to check if subset with sum X can be formed
        if (canFormSubset(A, N, X)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
    
    public static boolean canFormSubset(int[] A, int N, int X) {
        // DP array to store if a sum j is possible
        boolean[] dp = new boolean[X + 1];
        dp[0] = true; // Base case: sum of 0 is always possible
        
        // Process each element in the array
        for (int i = 0; i < N; i++) {
            int num = A[i];
            // Update the DP table in reverse to prevent overwriting
            for (int j = X; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        
        // Result is whether we can form the sum X
        return dp[X];
    }
}
