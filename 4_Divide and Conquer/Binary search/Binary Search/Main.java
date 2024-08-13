import java.util.*;

public class Main {
   
    public static int binary_search(int arr[], int x) {
        int size = arr.length;
        
        int left = 0, right = arr.length-1;

        while(right >= left) {
            int mid = (left + right) / 2;
            if(arr[mid] == x) {
                return mid + 1;
            }
            else if(arr[mid] > x) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        
        return -1;
    }
    

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(binary_search(arr, x));
            t--;
        }
    }
}