def dfs(board, word, i, j, k):
    if k == len(word):
        return True
    if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[k]:
        return False
    tmp = board[i][j]
    board[i][j] = '#'  # Mark as visited
    found = (dfs(board, word, i + 1, j, k + 1) or
             dfs(board, word, i - 1, j, k + 1) or
             dfs(board, word, i, j + 1, k + 1) or
             dfs(board, word, i, j - 1, k + 1))
    board[i][j] = tmp  # Restore original value
    return found

def word_search(board, word):
    for i in range(len(board)):
        for j in range(len(board[0])):
            if dfs(board, word, i, j, 0):
                return True
    return False

if __name__ == "__main__":
    R, C = map(int, input().split())
    board = [input().split() for _ in range(R)]
    word = input().strip() # Correct way to read grid
    print("true" if word_search(board, word) else "false")
