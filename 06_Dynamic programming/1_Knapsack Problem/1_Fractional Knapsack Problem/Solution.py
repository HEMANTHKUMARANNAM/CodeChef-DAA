def main():
    import sys
    input = sys.stdin.read
    data = input().split()

    n = int(data[0])
    wmax = float(data[1])

    items = []
    index = 2
    for _ in range(n):
        w = float(data[index])
        v = float(data[index + 1])
        value_per_weight = v / w  
        items.append((value_per_weight, w))
        index += 2

    items.sort(reverse=True, key=lambda x: x[0])

    ans = 0
    for value_per_weight, weight in items:
        if wmax <= 0:
            break
        weight_to_take = min(wmax, weight)
        ans += weight_to_take * value_per_weight
        wmax -= weight_to_take

    print(f"{ans:.16f}")

if __name__ == "__main__":
    main()
