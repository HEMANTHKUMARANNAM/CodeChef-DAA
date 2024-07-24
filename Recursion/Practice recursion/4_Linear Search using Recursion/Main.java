import java.util.Scanner;

public class Main {
    static int linearSearch(int[] arr, int n, int x) {
        //Write your code here
        if(n == arr.length)
        {
            return -1;
        }
        
        if(arr[n] == x)
        {
            return n;
        }
        
        return linearSearch(arr,n+1,x);
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(linearSearch(arr, 0, x));
        scanner.close();
    }
}
