import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W_max = sc.nextInt();

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        System.out.println(knapsack(N, W_max, weights, values));
    }

    public static int knapsack(int N, int W_max, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W_max + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W_max; w++) {
                dp[i][w] = dp[i-1][w];

                if (w >= weights[i-1]) {
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w - weights[i-1]] + values[i-1]);
                }
            }
        }

        return dp[N][W_max];
    }
}
