def floyd_warshall(N, edges):
    INF = float('inf')
    
    dist = [[INF] * N for _ in range(N)]

    for u, v, w in edges:
        dist[u][v] = min(dist[u][v], w)
        dist[v][u] = min(dist[v][u], w)
    

    for k in range(N):
        for i in range(N):
            for j in range(N):
                if dist[i][k] < INF and dist[k][j] < INF:
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    
    result = []
    for i in range(N):
        row = []
        for j in range(N):
            if i == j:
                m = min(dist[i])
                if m == INF:
                    row.append('-1')
                else:
                    row.append(str(m * 2))
            else:
                if dist[i][j] == INF:
                    row.append('-1')
                else:
                    row.append(str(dist[i][j]))
        result.append(' '.join(row))
    
    return result

import sys
input = sys.stdin.read
data = input().split()

index = 0
N = int(data[index])
index += 1
M = int(data[index])
index += 1

edges = []
for _ in range(M):
    u = int(data[index]) - 1
    index += 1
    v = int(data[index]) - 1
    index += 1
    w = int(data[index])
    index += 1
    edges.append((u, v, w))

results = floyd_warshall(N, edges)
for line in results:
    print(line)
