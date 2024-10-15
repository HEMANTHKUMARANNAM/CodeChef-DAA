import java.util.Arrays;

class main {

    // Directions to check if queens attack another
    static int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
    static int[] dy = {-1, 1, 0, -1, 1, 0, -1, 1};

    static boolean check(char[][] board, int n, int row, int col) {
        for (int k = 0; k < 8; k++) {
            int x = row, y = col;
            while (x >= 0 && x < n && y >= 0 && y < n) {
                if (board[x][y] == 'Q') {
                    return false; // Queen attacks another
                }
                x += dx[k];
                y += dy[k];
            }
        }
        return true; // Can place queen here
    }

    static void backtrack(int row, int n, char[][] board) {
        if (row == n) { // No more rows to fill
            for (char[] x : board) { // Print the solution
                System.out.println(new String(x));
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(board, n, row, col)) {
                board[row][col] = 'Q'; // Add the queen
                backtrack(row + 1, n, board);
                board[row][col] = '.'; // Remove the queen
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n]; // Initialise an empty board
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);
    }
}
