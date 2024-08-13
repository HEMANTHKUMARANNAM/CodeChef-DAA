
import java.util.*;

public class Main {
   
    public static int Search(int arr[], int x) {
        // Write your code here
        
        
        for(int i =0 ; i< arr.length ; i++ )
        {
            if( arr[i] == x )
            {
                return i+1;
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
            
            System.out.println(Search(arr, x));
            t--;
        }
    }
}