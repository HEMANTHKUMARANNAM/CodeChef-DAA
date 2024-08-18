# Replace '_' to solve the problem
def partition(a, size_a):
    pivot = a[size_a-1]
    idx = 0

    for i in range(size_a):
        if a[i] <= pivot:
            a[idx], a[i] = a[i], a[idx]
            idx += 1

    a[idx], a[size_a - 1] = a[size_a - 1], a[idx]


if __name__ == "__main__":
    n = int(input())

    a = list(map(int, input().split()))

    partition(a, n)

    for i in range(n):
        print(a[i], end=" ")

    print()