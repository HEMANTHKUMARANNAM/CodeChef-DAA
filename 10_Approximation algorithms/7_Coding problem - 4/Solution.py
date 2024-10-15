import sys
from collections import defaultdict

input = sys.stdin.read
data = input().splitlines()

T = int(data[0])
index = 1

results = []
for _ in range(T):
    N, W, Wr = map(int, data[index].split())
    index += 1
    
    weights = list(map(int, data[index].split()))
    index += 1
    
    total_weight = Wr
    weight_map = defaultdict(int)

    for w in weights:
        weight_map[w] += 1
    
    for weight, count in weight_map.items():
        pairs = count // 2
        total_weight += pairs * 2 * weight
    
    if total_weight >= W:
        results.append("YES")
    else:
        results.append("NO")

print("\n".join(results))