import java.util.Scanner;

class GCDBruteForce {
    // Update the code below
    public static int gcd_euclid(int a, int b) {
        
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        if(min==0)
        {
            return max;
        }
        
        
        return gcd_euclid(b , a%b );
        
        
        
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
            int result = gcd_euclid(a, b);
            System.out.println(result);
        }
        
        scanner.close();
    }
}