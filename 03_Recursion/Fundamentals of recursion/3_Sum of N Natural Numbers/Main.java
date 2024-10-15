public class Main {
    public static void main(String[] args) {
        System.out.println("Sum of first 5 natural numbers is " + sum(5));
    }

    static int sum(int n) {
        System.out.println("Sum(" + n + ") is called");
        if (n == 1) {
            System.out.println("Base Condition reached");
            return 1;
        }
        int sumN1 = sum(n - 1);
        System.out.println("Sum(" + n + ") = " + n + " + Sum(" + (n - 1) + ")");
        int sumN = n + sumN1;
        System.out.println("Sum(" + n + ") = " + n + " + " + sumN1);
        System.out.println("Sum(" + n + ") is returning " + sumN);
        return sumN;
    }
}
