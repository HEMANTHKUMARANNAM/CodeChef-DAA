def is_safe(board, row, col, n):
    # Check if there is a queen in the same column
    for i in range(row):
        if board[i][col] == 'Q':
            return False

    # Check if there is a queen in the left diagonal
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 'Q':
            return False

    # Check if there is a queen in the right diagonal
    for i, j in zip(range(row, -1, -1), range(col, n)):
        if board[i][j] == 'Q':
            return False

    return True

def solve_n_queens_util(board, row, n, result):
    if row == n:
        result.append([''.join(row) for row in board])
        return

    for col in range(n):
        if is_safe(board, row, col, n):
            board[row][col] = 'Q'
            solve_n_queens_util(board, row + 1, n, result)
            board[row][col] = '.'  # Backtrack

def solve_n_queens(n):
    board = [['.' for _ in range(n)] for _ in range(n)]
    result = []
    solve_n_queens_util(board, 0, n, result)
    return result

if __name__ == "__main__":
    n = int(input())
    solutions = solve_n_queens(n)
    solutions.reverse()
    for solution in solutions:
        print("\n".join(solution))
        print()
