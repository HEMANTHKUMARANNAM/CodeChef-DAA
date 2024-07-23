import java.util.Scanner;

public class Main {
    static int Factorial(int n) {
        if(n ==0)
        {
            return 1;
        }
        
        return n* Factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Factorial(n));
        scanner.close();
    }
}
