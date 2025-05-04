from sys import stdin

input = stdin.readline

n, m = map(int,input().strip().split())
G = [[] for _ in range(n+1)]
parents = [i for i in range(n+1)]
# Edges = []

for _ in range(m):
    a, b, c = map(int,input().strip().split())
    G[a].append((b,c))
    G[b].append((a,c))


def findParent(x):
    if x == parents[x]:
        return x
    parents[x] = findParent(parents[x])
    return parents[x]

def merge(a,b):
    aa = findParent(a)
    bb = findParent(b)
    if aa!=bb:
        parents[aa] = bb

Edges = []
for a in range(1,n+1):
    for b, c in G[a]:
        if a < b:
            Edges.append((c,a,b))

Edges.sort()

mst_cost = 0
INF_cost = -float('inf')
for cost, a, b in Edges:
    if findParent(a) != findParent(b):
        merge(a,b)
        mst_cost +=cost
        INF_cost = max(INF_cost, cost)
print(mst_cost-INF_cost)