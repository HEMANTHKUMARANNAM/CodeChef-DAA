import java.util.*;

class CodeChef {
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int d = 2; n > 1; d++) {
            while (n % d == 0) {
                factors.add(d);
                n /= d;
            }
            if (d * d > n) {
                if (n > 1) factors.add(n);
                break;
            }
        }
        return factors;
    }
    
    // Update the function below
    public static int gcdMiddleSchool(int a, int b) {
        List<Integer> factorsA = primeFactors(a);
        List<Integer> factorsB = primeFactors(b);
        
        int gcd = 1, i = 0, j = 0;
        while (i < factorsA.size() && j < factorsB.size()) {
            if (factorsA.get(i).equals(factorsB.get(j))) {
                gcd *= factorsA.get(i);
                i++;
                j++;
            } else if (factorsA.get(i) < factorsB.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return gcd;
        
        






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
            int result = gcdMiddleSchool(a, b);
            System.out.println(result);
        }
        
        scanner.close();
    }
}