
from sys import stdin
from collections import deque

n, m = map(int,input().split())

G = [[] for _ in range(n)]
indegree = [0] * n

for _ in range(m):
    a, b = map(int,input().split())
    G[a-1].append(b-1) # a -> b 
    # G[b].append(a)
    indegree[b-1]+=1

def topologicalSort():
    global n, m
    deq = deque([])
    res = []
    for idx in range(n):
        if indegree[idx] == 0:
            deq.append(idx)
            res.append(idx+1)
    while deq:
        cur = deq.popleft()

        for nxt in G[cur]:
            if indegree[nxt]-1 == 0:
                indegree[nxt]-=1
                deq.append(nxt)
                res.append(nxt+1)
            else:
                indegree[nxt]-=1
    print(*res)

topologicalSort()
