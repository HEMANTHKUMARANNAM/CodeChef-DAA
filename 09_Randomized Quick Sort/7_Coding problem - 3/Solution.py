# cook your dish here
t = int(input())

for _ in range(t):
    N = int(input())
    weights = list(map(int, input().split()))
    jumps = list(map(int, input().split()))
    positions = list(range(N))
    
    frogs = [(weights[i], positions[i], jumps[i]) for i in range(N)]
    frogs.sort()
    
    total_hits = 0
    
    for i in range(1, N):
        while frogs[i][1] <= frogs[i - 1][1]:
            frogs[i] = (frogs[i][0], frogs[i][1] + frogs[i][2], frogs[i][2])
            total_hits += 1
            
    print(total_hits)