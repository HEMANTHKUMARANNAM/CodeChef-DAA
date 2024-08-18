import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your solution here
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for(int i =0 ; i< t ; i++)
        {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j =0 ; j< n ; j++ )
            {
                a[j] = sc.nextInt();
            }
            
            Arrays.sort(a);
            
            int count =0;
            
            for(int j=0 ; j< n ; j++)
            {
                int index = upperBound(a,a[j]);
                if( index > n-index )
                {
                    count++;
                }
            }
            
            System.out.println(count);
        
        }


    }

    // Custom implementation of upper_bound
    public static int upperBound(int[] array, int key) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
