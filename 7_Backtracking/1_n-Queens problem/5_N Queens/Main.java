import java.util.*;

class main {

    static List<List<String>> nQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        List<List<String>> ans = new ArrayList<>();

        // Write your solution here

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<String>> a = nQueens(n);
        Collections.sort(a, (x, y) -> {
            for (int i = 0; i < n; i++) {
                int cmp = x.get(i).compareTo(y.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        for (List<String> board : a) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
