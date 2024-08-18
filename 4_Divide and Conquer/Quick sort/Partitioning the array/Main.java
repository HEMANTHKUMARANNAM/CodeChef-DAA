import java.util.*;

public class Main 
{
    
    // Replace '_' to solve the problem
    static void partition(int[] a, int size_a) {
        int pivot = a[size_a-1];
        int idx = 0;

        for (int i = 0; i < size_a; i++) {
            if (a[i] <= pivot) 
            {
                int temp = a[idx];
                a[idx] = a[i];
                a[i] = temp;
                idx++;
            }
        }

        int temp = a[idx];
        a[idx] = a[size_a - 1];
        a[size_a - 1] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        partition(a, n);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }
}