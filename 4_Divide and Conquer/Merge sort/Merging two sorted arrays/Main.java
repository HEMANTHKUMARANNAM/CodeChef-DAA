import java.util.*;

public class Main {

    // Merge array a and b into array c
    static void merge(int[] a, int size_a, int[] b, int size_b, int[] c) {
        // Replace '_' to solve the problem
        int idx1 = 0, idx2 = 0;
        int idx = 0;

        while ( idx1 < size_a && idx2 < size_b) {
            if (a[idx1] < b[idx2]) {
                c[idx++] = a[idx1++];
            } else {
                c[idx++] = b[idx2++];
            }
        }

        while ( idx1 < size_a) {
            c[idx++] = a[idx1++];
        }

        while ( idx2 < size_b) {
            c[idx++] = b[idx2++];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        int[] c = new int[n + m];
        merge(a, n, b, m, c);

        for (int i = 0; i < n + m; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }
}
