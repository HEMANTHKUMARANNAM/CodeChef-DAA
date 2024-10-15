import java.util.Scanner;

public class Main {
    static String checkPalindrome(String s, int n) {
        //Write your code here
        if( n == s.length()/2 )
        {
            return "YES";
        }
        
        if( s.charAt(n) == s.charAt(s.length()-1-n) )
        {
            return checkPalindrome(s,n+1);
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(checkPalindrome(s, 0));
        scanner.close();
    }
}
