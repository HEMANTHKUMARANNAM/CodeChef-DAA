import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        if (canFormSubset(A, N, X)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
    
    public static boolean canFormSubset(int[] A, int N, int X) {
        boolean[] dp = new boolean[X + 1];
        dp[0] = true; // Base case: sum of 0 is always possible
        
        for (int i = 0; i < N; i++) {
            int num = A[i];
            for (int j = X; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        
        return dp[X];
    }
}
