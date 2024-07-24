import java.util.Scanner;

public class Main {
    static String binary(int n) {
        //Write your code here
        
        if(n ==0)
        {
            return "";
        }
        
        if(n%2 == 0)
        {
            return binary(n/2)+"0";
        }
        
        return binary(n/2) + "1";
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(binary(n));
        scanner.close();
    }
}
