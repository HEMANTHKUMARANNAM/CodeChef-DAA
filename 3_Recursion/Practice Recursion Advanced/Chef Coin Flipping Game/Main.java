import java.util.Scanner;

public class Main {
    public static int countWays(int S) {
        if (S < 0) return 0;
        if (S == 0) return 1;
        return countWays(S - 1) + countWays(S - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        System.out.println(countWays(S));
    }
}