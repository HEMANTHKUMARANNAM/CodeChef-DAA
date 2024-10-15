import java.util.*;

public class Main {
    public static boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        char tmp = board[i][j];
        board[i][j] = '#'; // Mark as visited
        boolean found = dfs(board, word, i+1, j, k+1) || dfs(board, word, i-1, j, k+1) ||
                        dfs(board, word, i, j+1, k+1) || dfs(board, word, i, j-1, k+1);
        board[i][j] = tmp; // Restore original value
        return found;
    }

    public static boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = scanner.next().charAt(0);
            }
        }
        String word = scanner.next();
        System.out.println(wordSearch(board, word) ? "true" : "false");
    }
}