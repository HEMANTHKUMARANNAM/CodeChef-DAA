def generate_parentheses(n):
    result = []
    
    def backtrack(s='', left=0, right=0):
        if len(s) == 2 * n:
            result.append(s)
            return
        if left < n:
            backtrack(s + '(', left + 1, right)
        if right < left:
            backtrack(s + ')', left, right + 1)
    
    backtrack()
    return sorted(result)


T = int(input())

for _ in range(T):
    N = int(input())
    result = generate_parentheses(N)
    
    print(len(result))
    for s in result:
        print(s)

