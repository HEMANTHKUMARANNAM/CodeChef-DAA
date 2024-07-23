import java.util.Scanner;

class GCDBruteForce {
    // Solution as follows
    public static int gcdBruteForce(int a, int b) {
        // Find the smaller of the two numbers
        
        int m = Math.min(a,b);

        
        // Start from the smaller number and work our way down
        
        for(int i = m ; i>1 ; i--)
        {
            if(a%i==0 && b%i==0)
            {
                return i;
            }
        }





        
        // This line should never be reached for positive integers
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get test cases 't'
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            // Get user input
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Calculate and print the GCD
            int result = gcdBruteForce(a, b);
            System.out.println(result);
        }
        
        scanner.close();
    }
}