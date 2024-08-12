import java.util.Scanner;

class BinaryDigitCounter {
    public static String intToBinary(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return binary.toString();
    }
    
    // update the function below
    public static int countBinaryDigits(int n) 
    {
        if(n==0)
        {
            return 0;
        }
        
        return 1+ countBinaryDigits(n/2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            String binary = intToBinary(N);
            int digitCount = countBinaryDigits(N);
            System.out.println(digitCount);
        }
        
        scanner.close();
    }
}
