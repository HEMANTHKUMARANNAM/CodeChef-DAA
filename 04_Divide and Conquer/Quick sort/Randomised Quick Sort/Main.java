import java.util.*;

public class Main {

    // l is the leftmost index of the subarray
    // r is the rightmost index of the subarray
    static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int idx = l;

        for (int i = l; i < r; i++) {
            if (a[i] <= pivot) {
                // Swap elements if they are less than or equal to the pivot
                int temp = a[idx];
                a[idx] = a[i];
                a[i] = temp;
                idx++;
            }
        }

        // Swap the pivot to its final position
        int temp = a[idx];
        a[idx] = a[r];
        a[r] = temp;

        // Return the final pivot index
        return idx;
    }

    // l is the leftmost index of the subarray
    // r is the rightmost index of the subarray
    static void randomPart(int[] a, int l, int r) {
        Random rand = new Random();
        int randIdx = l + rand.nextInt(r - l + 1);
        // Swap a random element with the last element (pivot)
        int temp = a[randIdx];
        a[randIdx] = a[r];
        a[r] = temp;
    }

    // l is the leftmost index of the subarray
    // r is the rightmost index of the subarray
    static void sort(int[] a, int l, int r) {
        if (r - l < 1)
            return; // Arrays of size 1 and 0 are already sorted

        randomPart(a, l, r);
        int pivot = partition(a, l, r);

        // Sorting both halves of the array
        sort(a, l, pivot - 1);
        sort(a, pivot + 1, r);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        sort(a, 0, n - 1);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}