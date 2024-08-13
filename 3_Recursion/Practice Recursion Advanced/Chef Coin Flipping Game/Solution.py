def countWays(S):
    if S < 0:
        return 0
    if S == 0:
        return 1
    return countWays(S - 1) + countWays(S - 2)

if __name__ == "__main__":
    S = int(input())
    print(countWays(S))