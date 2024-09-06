# cook your dish here
import heapq

class UnionFind:
    def __init__(self, size):
        self.parent = [i for i in range(size)]

    def find(self, u):
        if u != self.parent[u]:
            self.parent[u] = self.find(self.parent[u])
        return self.parent[u]

    def union(self, u, v):
        u = self.find(u)
        v = self.find(v)
        if u != v:
            self.parent[u] = v

def main():
    t = int(input())
    for _ in range(t):
        graph = {}
        edgeList = []
        n, m = map(int, input().split())
        for i in range(n):
            graph[i] = []
        for _ in range(m):
            u, v, w = map(int, input().split())
            graph[u].append((v, w))
            graph[v].append((u, w))
            edgeList.append((u, v, w))
        edgeList.sort(key=lambda x: x[2])

        uf = UnionFind(n)
        mst = 0
        cnt = 0

        for edge in edgeList:
            u, v, w = edge
            if uf.find(u) == uf.find(v):
                continue
            else:
                uf.union(u, v)
                mst += w
                cnt += 1

        if cnt != n - 1:
            print("NO")
            continue

        dist = [float('inf')] * n
        edgeChosen = [0] * n
        dist[0] = 0
        pq = [(0, 0)]

        while pq:
            d, u = heapq.heappop(pq)
            if dist[u] < d:
                continue
            for v, w in graph[u]:
                if dist[v] > w + d:
                    dist[v] = w + d
                    heapq.heappush(pq, (w + d, v))
                    edgeChosen[v] = w
                elif dist[v] == w + d and w < edgeChosen[v]:
                    edgeChosen[v] = w

        mdt = sum(edgeChosen)
        if mdt == mst:
            print("YES")
        else:
            print("NO")

if __name__ == "__main__":
    main()
