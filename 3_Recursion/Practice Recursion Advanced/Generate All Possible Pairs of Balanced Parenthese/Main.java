import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void generateParenthesis(int n, int open, int close, String str, List<String> result) {
        if(open == n && close == n) {
            result.add(str);
            return;
        }
        if(open < n) {
            generateParenthesis(n, open + 1, close, str + "(", result);
        }
        if(close < open) {
            generateParenthesis(n, open, close + 1, str + ")", result);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> result = generateParenthesis(n);
        Collections.sort(result); // Sorting the result list
        for(String s : result) {
            System.out.println(s);
        }
    }
}