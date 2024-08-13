import java.util.Scanner;

// Replace '_' to solve the problem

class MergeSort {

    public static void Merge(int[] a, int size_a, int[] b, int size_b, int[] c) {
        int idx1 = 0, idx2 = 0;
        int idx = 0;

        while (idx1 < size_a && idx2 < size_b) {
            if ( a[idx1] < b[idx2]) {
                c[idx] = a[idx1];
                idx1++;
            } else {
                c[idx] = b[idx2];
                idx2++;
            }
            idx++;
        }

        while (idx1 < size_a) {
            c[idx] = a[idx1];
            idx1++;
            idx++;
        }

        while (idx2 < size_b) {
            c[idx] = b[idx2];
            idx2++;
            idx++;
        }
    }

    public static void Sort(int[] a, int size_a) {
        if (size_a <= 1) {
            return;
        }

        int mid = size_a/2;

        int sz1 = mid;
        int sz2 = size_a-mid;

        int[] a1 = new int[sz1];
        int[] a2 = new int[sz2];

        for (int i = 0; i < sz1; i++) {
            a1[i] = a[i];
        }

        for (int i = mid,j=0; i < size_a; i++,j++) {
            a2[j] = a[i];
        }

        Sort(a1, sz1); 
        Sort(a2, sz2 );

        Merge(a1, sz1, a2, sz2,a );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Sort(a, n);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
