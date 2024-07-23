import java.util.Scanner;

public class Main {
    static void printPattern(int n) {
        //Write your code here
        
        if(n==0)
        {
            return;
        }
        
        for(int i =0 ; i< n ; i++)
        {
            System.out.print("*");
        }
        System.out.println("");
        
        printPattern(n-1);
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printPattern(n);
        scanner.close();
    }
}
