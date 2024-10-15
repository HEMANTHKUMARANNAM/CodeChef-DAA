import java.util.*;

public class Main {

    private static final int MOD = 1000000007;

    private static void merge(int[] a, int sizeA, int[] b, int sizeB, int[] c) {
        int idx1 = 0, idx2 = 0, idx = 0;

        while (idx1 < sizeA && idx2 < sizeB) {
            if (a[idx1] < b[idx2]) {
                c[idx++] = a[idx1++];
            } else {
                c[idx++] = b[idx2++];
            }
        }

        while (idx1 < sizeA) {
            c[idx++] = a[idx1++];
        }

        while (idx2 < sizeB) {
            c[idx++] = b[idx2++];
        }
    }

    private static long countInversions(int[] a, int sizeA, int[] b, int sizeB) {
        int ptr = sizeB - 1;
        long ans = 0;

        for (int i = 0; i < sizeA; i++) {
            while (ptr >= 0 && b[ptr] < a[i]) {
                ptr--;
            }
            ans = (ans + (sizeB - 1 - ptr)) % MOD;
        }

        return ans;
    }

    private static long sortAndCount(int[] a, int sizeA) {
        if (sizeA < 2) {
            return 0;
        }

        int mid = sizeA / 2;

        int[] a1 = Arrays.copyOfRange(a, 0, mid);
        int[] a2 = Arrays.copyOfRange(a, mid, sizeA);

        int sz1 = a1.length;
        int sz2 = a2.length;

        long left = sortAndCount(a1, sz1);
        long right = sortAndCount(a2, sz2);

        long num = countInversions(a1, sz1, a2, sz2);

        int[] merged = new int[sizeA];
        merge(a1, sz1, a2, sz2, merged);

        System.arraycopy(merged, 0, a, 0, sizeA);

        return ((left + right) % MOD + num) % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }

            System.out.println(sortAndCount(a, n));
        }

        sc.close();
    }
}
