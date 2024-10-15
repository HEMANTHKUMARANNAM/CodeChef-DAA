# cook your dish here
MOD = 10**9 + 7

def merge(a, size_a, b, size_b, c):
    idx1, idx2, idx = 0, 0, 0

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

def count_inversions(a, size_a, b, size_b):
    ptr = size_b - 1
    ans = 0
    for i in range(size_a):
        while ptr >= 0 and b[ptr] < a[i]:
            ptr -= 1
        ans = (ans + (size_b - 1 - ptr)) % MOD
    return ans

def sort_and_count(a, size_a):
    if size_a < 2:
        return 0

    mid = size_a // 2

    a1 = a[:mid]
    a2 = a[mid:]

    sz1 = len(a1)
    sz2 = len(a2)


    left = sort_and_count(a1, sz1)
    right = sort_and_count(a2, sz2)

    num = count_inversions(a1, sz1, a2, sz2)


    merged = [0] * size_a
    merge(a1, sz1, a2, sz2, merged)

    for i in range(size_a):
        a[i] = merged[i]

    return ((left + right) % MOD + num) % MOD


t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    print(sort_and_count(a, n))