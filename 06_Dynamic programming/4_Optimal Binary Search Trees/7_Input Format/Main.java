import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] F = new int[N];
        for (int i = 0; i < N; i++) {
            F[i] = sc.nextInt();
        }

        System.out.println(optimalBST(F, N));
    }

    public static int optimalBST(int[] F, int N) {
        int[][] cost = new int[N][N];
        int[] freqSum = new int[N];

        for (int i = 0; i < N; i++) {
            freqSum[i] = F[i] + (i > 0 ? freqSum[i - 1] : 0);
        }

        for (int i = 0; i < N; i++) {
            cost[i][i] = F[i];
        }

       
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                for (int r = i; r <= j; r++) {
                    int leftCost = (r > i) ? cost[i][r - 1] : 0;
                    int rightCost = (r < j) ? cost[r + 1][j] : 0;
                    int totalCost = leftCost + rightCost + sumFrequencies(freqSum, i, j);

                    cost[i][j] = Math.min(cost[i][j], totalCost);
                }
            }
        }

        return cost[0][N - 1];
    }

    public static int sumFrequencies(int[] freqSum, int i, int j) {
        return freqSum[j] - (i > 0 ? freqSum[i - 1] : 0);
    }
}
