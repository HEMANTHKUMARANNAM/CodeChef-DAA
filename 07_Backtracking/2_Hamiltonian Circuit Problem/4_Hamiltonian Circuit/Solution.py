def check(v, next_v, circuit, mat):
    # Check if 'next' vertex can be added after vertex 'v'
    if not mat[v][next_v] or next_v in circuit:
        return False
    return True

def backtrack(v, n, circuit, ans, mat):
    if len(circuit) == n:  # Circuit is completed
        if mat[circuit[0]][v]:  # Check if cycle is completed
            circuit.append(circuit[0])  # Add the starting vertex to complete the cycle
            ans.append(list(circuit))   # Store the cycle
            circuit.pop()  # Remove the added start vertex to explore other paths
        return

    for i in range(1, n + 1):
        if not check(v, i, circuit, mat):
            continue
        # If adjacent and not visited, add it to the circuit
        circuit.append(i)
        backtrack(i, n, circuit, ans, mat)
        circuit.pop()  # Backtrack to explore other options

def hamiltonian_circuit(n, mat):
    circuit = []  # Initially empty circuit
    ans = []  # To store all valid circuits

    for i in range(1, n + 1):  # Fix the starting vertex
        circuit.append(i)  # Add i to the circuit
        backtrack(i, n, circuit, ans, mat)
        circuit.pop()  # Remove i from the circuit

    return ans

if __name__ == "__main__":
    # Input for number of vertices and edges
    n, m = map(int, input().split())

    # Adjacency matrix
    mat = [[False] * (n + 1) for _ in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())
        mat[a][b] = True
        mat[b][a] = True

    cycles = hamiltonian_circuit(n, mat)

    # Sorting cycles lexicographically
    cycles.sort(key=lambda x: str(x))

    # Output the Hamiltonian cycles
    for cycle in cycles:
        print(" ".join(map(str, cycle)))
