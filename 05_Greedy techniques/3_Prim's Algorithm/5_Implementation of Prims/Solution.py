N = 10
vis = [False] * N
adj = [[] for _ in range(N)]
MST = []

class Pair:
    def __init__(self, first, second):
        self.first = first
        self.second = second

def prims(source, n):
    global MST, vis

    # Stores weight, newly added vertex, and parent vertex
    pq = []

    def push_to_pq(item):
        pq.append(item)
        pq.sort()

    push_to_pq((0, source))  # push the starting vertex to the pq

    while pq:
        node = pq.pop(0)

        v = node[1]

        # If vertex is already processed, continue
        if vis[v]:
            continue

        vis[v] = True  # Mark vertex as processed

        print(f"Adding vertex {v} to the MST")

        if len(node) == 3:
            MST.append(Pair(node[2], v))  # Push the edge into the MST

        for edge in adj[v]:
            push_to_pq((edge.second, edge.first, v))

    print("\nEdgelist of MST is:")

    for edge in MST:
        print(edge.first, edge.second)

if __name__ == "__main__":
    for i in range(N):
        vis.append(False)
        adj.append([])

    # Adjacency list
    adj[1].append(Pair(2, 4))
    adj[2].append(Pair(1, 4))

    adj[1].append(Pair(3, 4))
    adj[3].append(Pair(1, 4))

    adj[2].append(Pair(3, 2))
    adj[3].append(Pair(2, 2))

    adj[3].append(Pair(4, 3))
    adj[4].append(Pair(3, 3))

    adj[3].append(Pair(5, 2))
    adj[5].append(Pair(3, 2))

    adj[3].append(Pair(6, 4))
    adj[6].append(Pair(3, 4))

    adj[4].append(Pair(6, 3))
    adj[6].append(Pair(4, 3))

    adj[5].append(Pair(6, 3))
    adj[6].append(Pair(5, 3))

    prims(1, 6)
