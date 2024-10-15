T = int(input())

for _ in range(T):
    N, B = map(int,input().split())
    A = sorted(list(set(map(int,input().split()))))
    N = len(A)
    
    combs = []
    def trycombs(L, ib):
        n = sum(L)
        if ib >= N or A[ib] + n > B:
            return
        for i in range(ib,N):
            a = A[i]
            if n + a == B:
                combs.append(L + [a])
            elif n + a < B:
                trycombs(L + [a], i)
            else: 
                break 
    
    trycombs([],0)
    print(len(combs))
    for c in combs:
        print(*c)