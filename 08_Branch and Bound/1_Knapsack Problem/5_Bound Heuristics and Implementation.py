import heapq
import sys

infinity = sys.maxsize

def cmp(a, b):
    return a[1] * b[0] > a[0] * b[1]

# Pick items from index idx, weight remaining
def fractional_knapsack(idx, items, weight):
    ans = 0
    for i in range(idx, len(items)):
        if items[i][0] <= weight:
            weight -= items[i][0]
            ans += items[i][1]
        else:
            fraction = weight / items[i][0]
            ans += fraction * items[i][1]

    return int(ans)

def branch_and_bound(n, wmax, items):
    # q stores [cost + lower_bound, weight of the items, cost of the items, next item to consider]
    q = []

    # Invert the sign of all the items
    items = [(x[0], -x[1]) for x in items]

    # Presort to perform fractional knapsack
    items.sort(key=lambda x: (x[1], -x[0]))

    upper_bound = infinity

    heapq.heappush(q, [0 + fractional_knapsack(0, items, wmax), 0, 0, 0])

    while q:
        cost_lower_bound, weight, cost, item = heapq.heappop(q)

        if cost_lower_bound >= upper_bound:
            continue

        # At least a solution with "cost" is promised
        upper_bound = min(upper_bound, cost)

        for i in range(item, n):
            if items[i][0] + weight > wmax:  # weight limit exceeded
                continue
            new_cost = cost + items[i][1]
            new_weight = weight + items[i][0]
            cost_lower_bound = new_cost + fractional_knapsack(i, items, wmax - new_weight)
            heapq.heappush(q, [cost_lower_bound, new_weight, new_cost, i + 1])

    return -upper_bound  # invert the sign

if __name__ == "__main__":
    n, wmax = map(int, input().split())
    items = [tuple(map(int, input().split())) for _ in range(n)]

    print(branch_and_bound(n, wmax, items))