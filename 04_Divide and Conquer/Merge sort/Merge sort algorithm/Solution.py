# Replace '_' to solve the problem

def Merge(a, size_a, b, size_b, c):
    idx1 = 0
    idx2 = 0
    idx = 0

    while idx1 < size_a and idx2 < size_b:
        if a[idx1] < b[idx2]:
            c[idx] = a[idx1]
            idx1 += 1
        else:
            c[idx] = b[idx2]
            idx2 += 1
        idx += 1

    while idx1 < size_a:
        c[idx] = a[idx1]
        idx1 += 1
        idx += 1

    while idx2 < size_b:
        c[idx] = b[idx2]
        idx2 += 1
        idx += 1

def Sort(a, size_a):
    if size_a <= 1:
        return

    mid = size_a//2

    sz1 = mid
    sz2 = size_a - mid

    a1 = [0] * sz1
    a2 = [0] * sz2

    for i in range(mid):
        a1[i] = a[i]

    for i in range(mid ,size_a ):
        a2[i-mid] = a[i]

    Sort(a1, sz1)
    Sort(a2, sz2)

    Merge(a1, sz1, a2, sz2 , a )

if __name__ == "__main__":
    n = int(input())
    a = list(map(int , input().split()))

    Sort(a, n)

    for i in range(n):
        print(a[i], end=" ")
    print()
