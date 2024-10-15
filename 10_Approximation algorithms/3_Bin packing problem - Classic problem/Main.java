import java.util.Arrays;
import java.util.Scanner;

class Codechef {
    public static int firstFitDecreasingBinPacking(int[] itemSizes, int binCapacity) {
        Arrays.sort(itemSizes);
        int[] bins = new int[itemSizes.length];
        int binCount = 0;

        for (int i = itemSizes.length - 1; i >= 0; i--) {
            boolean placed = false;
            for (int j = 0; j < binCount; j++) {
                if (bins[j] + itemSizes[i] <= binCapacity) {
                    bins[j] += itemSizes[i];
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                bins[binCount] = itemSizes[i];
                binCount++;
            }
        }

        return binCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testCase = 0; testCase < t; testCase++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int result = firstFitDecreasingBinPacking(arr, M);
            System.out.println(result);
        }
        scanner.close();
    }
}
