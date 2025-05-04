from sys import stdin
from sys import setrecursionlimit
setrecursionlimit(pow(10,5)*3)
input = stdin.readline

n, m, k = map(int,input().split())

G = [[] for _ in range(n+1)]
children = [0] * (n+1)
indegree = [0] * (n+1)

for _ in range(n-1):
    a, b = map(int,input().split())
    G[a].append(b)
    indegree[b]+=1
    G[b].append(a)

def dfs(node):
    global children
    children[node]+=1
    for nxt in G[node]:
        if children[nxt] == 0:
            dfs(nxt)
            children[node] += children[nxt]

dfs(m)
for __ in range(k):
    target = int(input())
    print(children[target])
