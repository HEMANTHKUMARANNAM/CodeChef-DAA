import java.util.Scanner;

public class Main {
    // Pad the numbers with 0 to make their sizes equal
    static void makeEqualSize(StringBuilder A, StringBuilder B) {
        while (A.length() < B.length()) {
            A.insert(0, '0');
        }
        while (B.length() < A.length()) {
            B.insert(0, '0');
        }
    }

    // Digit subtraction of the numbers
    static String subtract(String A, String B) {
        StringBuilder C, D;
        C = new StringBuilder(A);
        D = new StringBuilder(B);
        makeEqualSize(C, D);
        A = C.toString();
        B = D.toString();

        boolean sign = false;
        if (A.compareTo(B) < 0) {
            sign = true;
            String temp = A;
            A = B;
            B = temp;
        }
        int borrow = 0;
        StringBuilder res = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            int dA = (A.charAt(i) - '0') - borrow;
            int dB = (B.charAt(i) - '0');

            if (dA < dB) {
                dA += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            int digit = (dA - dB) % 10;
            char d = (char) (digit + '0');
            res.insert(0, d);
        }
        if (sign) {
            res.insert(0, '-');
        }
        return res.toString();
    }

    // Digit addition of the numbers
    static String add(String A, String B) {
        if (A.length() > 0 && A.charAt(0) == '-') {
            return subtract(B, A);
        }
        if (B.length() > 0 && B.charAt(0) == '-') {
            return subtract(A, B);
        }

        StringBuilder C, D;
        C = new StringBuilder(A);
        D = new StringBuilder(B);
        makeEqualSize(C, D);
        A = C.toString();
        B = D.toString();

        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            int sum = (A.charAt(i) - '0') + (B.charAt(i) - '0') + carry;
            int digit = sum % 10;
            carry = sum / 10;
            char d = (char) (digit + '0');
            res.insert(0, d);
        }
        if (carry != 0) {
            char d = (char) (carry + '0');
            res.insert(0, d);
        }
        return res.toString();
    }

    // Remove extra leading zeroes
    static String removeLeadingZeros(String S) {
        boolean f = true;
        StringBuilder res = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (f && c == '0') {
                continue;
            }
            f = false;
            res.append(c);
        }
        return res.toString();
    }

    // Multiply the number with powers of 10
    static String multiplyTenPower(String S, int power) {
        S = removeLeadingZeros(S);
        StringBuilder result = new StringBuilder(S);
        while (power-- > 0) {
            result.append('0');
        }
        return result.toString();
    }

    // Function to multiply the numbers
    static String multiply(String A, String B) {
        if (A.length() < B.length()) {
            String temp = A;
            A = B;
            B = temp;
        }

        StringBuilder C, D;
        C = new StringBuilder(A);
        D = new StringBuilder(B);
        makeEqualSize(C, D);
        A = C.toString();
        B = D.toString();


        int N = A.length();

        if (N == 1) { // Base case
            int res = (A.charAt(0) - '0') * (B.charAt(0) - '0');
            return Integer.toString(res);
        }

        // Pad one extra 0 to make the length even
        if ((N & 1) == 1) {
            N++;
            A = "0" + A;
            B = "0" + B;
        }

        int firstHalfSize = N - N / 2;
        int secondHalfSize = N / 2;

        // Distribute into two halves
        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();
        StringBuilder b1 = new StringBuilder();
        StringBuilder b2 = new StringBuilder();

        for (int i = 0; i < firstHalfSize; i++) {
            a1.append(A.charAt(i));
            b1.append(B.charAt(i));
        }

        for (int i = firstHalfSize; i < N; i++) {
            a2.append(A.charAt(i));
            b2.append(B.charAt(i));
        }

        String A1 = a1.toString();
        String B1 = b1.toString();
        String A2 = a2.toString();
        String B2 = b2.toString();

        // Take all the smaller multiplications
        String W = multiply(A1, B1);
        String X = multiply(A2, B2);
        String Y = multiply(add(A1, A2), add(B1, B2));

        // Store the answer
        String ans = add(add(multiplyTenPower(W, N), multiplyTenPower(subtract(Y, add(W, X)), N / 2)), X);

        // // Return the answer with no leading zeros
        return removeLeadingZeros(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0) {
            String num1 = scanner.nextLine();
            String num2 = scanner.nextLine();

            System.out.println(multiply(num1, num2));
        }
    }
}