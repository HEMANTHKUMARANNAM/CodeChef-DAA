# cook your dish here

import heapq

class Job:
    def __init__(self, id, t, d):
        self.id = id
        self.t = t
        self.d = d

    def __lt__(self, other):
        return self.d < other.d

def maxfun(joblist):
    pq = []
    for job in joblist:
        heapq.heappush(pq, job)
    
    order = []
    currtime = 0
    maxlate = 0

    while pq:
        curr = heapq.heappop(pq)
        currtime += curr.t 
        order.append(curr.id)
        
        late = max(0, currtime - curr.d)
        maxlate = max(late, maxlate)

    print(maxlate)

    print(" ".join(map(str, order)))


t = int(input())

joblist = []
for i in range(t):
    time, dead = map(int, input().split())
    job = Job(i + 1, time, dead)
    joblist.append(job)

maxfun(joblist)
