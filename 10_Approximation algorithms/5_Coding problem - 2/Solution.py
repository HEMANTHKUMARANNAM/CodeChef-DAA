def max_total_energy(T, test_cases):
    results = []
    
    for i in range(T):
        N, M, H = test_cases[i][0]
        A = test_cases[i][1]
        B = test_cases[i][2]

        A.sort(reverse=True)
        B.sort(reverse=True)

        max_energy = 0
        for j in range(min(N, M)):
            max_energy += min(A[j], B[j] * H)
        
        results.append(max_energy)
    
    return results


T = int(input())
test_cases = []

for _ in range(T):
    N, M, H = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    test_cases.append(((N, M, H), A, B))

results = max_total_energy(T, test_cases)

for res in results:
    print(res)
