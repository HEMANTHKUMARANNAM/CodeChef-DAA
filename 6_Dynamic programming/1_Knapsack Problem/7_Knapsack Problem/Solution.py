def knapsack(N, W_max, weights, values):
    dp = [[0] * (W_max + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for w in range(W_max + 1):
            dp[i][w] = dp[i-1][w]  
            if w >= weights[i-1]:
                dp[i][w] = max(dp[i][w], dp[i-1][w - weights[i-1]] + values[i-1])

    return dp[N][W_max]

def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    N = int(data[0])
    W_max = int(data[1])

    weights = []
    values = []

    index = 2
    for _ in range(N):
        weights.append(int(data[index]))
        values.append(int(data[index + 1]))
        index += 2

    print(knapsack(N, W_max, weights, values))

if __name__ == "__main__":
    main()
