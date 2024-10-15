def generateParenthesis(n):
    def backtrack(s='', left=0, right=0):
        if len(s) == 2 * n:
            result.append(s)
            return
        if left < n:
            backtrack(s + '(', left + 1, right)
        if right < left:
            backtrack(s + ')', left, right + 1)
    
    result = []
    backtrack()
    return result

# Get user input
n = int(input())
result = generateParenthesis(n)

# Print each balanced parenthesis string on a new line
for parentheses in result:
    print(parentheses)