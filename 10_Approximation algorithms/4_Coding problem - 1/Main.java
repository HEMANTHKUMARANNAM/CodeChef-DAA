import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Codechef {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                arr.add(scanner.nextInt());
            }

            int result = firstFitDecreasingBinPacking(arr, M);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int firstFitDecreasingBinPacking(List<Integer> itemSizes, int binCapacity) {
        Collections.sort(itemSizes, Collections.reverseOrder());
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int ele : itemSizes) {
            if (ele % 2 == 0) {
                even.add(ele);
            } else {
                odd.add(ele);
            }
        }

        int ans = 0;
        ans += pack(even, binCapacity);
        ans += pack(odd, binCapacity);

        return ans;
    }

    private static int pack(List<Integer> items, int binCapacity) {
        List<Integer> bins = new ArrayList<>();

        for (int item : items) {
            boolean placed = false;
            for (int i = 0; i < bins.size(); i++) {
                if (bins.get(i) + item <= binCapacity) {
                    bins.set(i, bins.get(i) + item);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                bins.add(item);
            }
        }

        return bins.size();
    }
}
