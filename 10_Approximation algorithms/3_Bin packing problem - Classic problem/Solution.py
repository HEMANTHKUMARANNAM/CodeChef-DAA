def first_fit_decreasing_bin_packing(item_sizes, bin_capacity):
    sorted_item_sizes = sorted(item_sizes, reverse=True)
    bins = []

    for item in sorted_item_sizes:
        placed = False
        for i in range(len(bins)):
            if bins[i] + item <= bin_capacity:
                bins[i] += item
                placed = True
                break
        if not placed:
            bins.append(item)

    return len(bins)

t = int(input())
for _ in range(t):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    result = first_fit_decreasing_bin_packing(arr, M)
    print(result)
