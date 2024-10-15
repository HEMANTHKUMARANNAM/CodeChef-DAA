def search(arr, x, n):
    # Write your code here
    for i in range(n):
        if arr[i] == x:
            return i+1
    
    return -1

if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        n, x = map(int, input().split())
        arr = list(map(int, input().split()))

        result = search(arr, x, n)
        print(result)
