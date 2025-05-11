#include <bits/stdc++.h>
using namespace std;
int N, M, K, c[30'005], a, b, dp[3'005];
struct DisjointSet
{
    std::vector<int> parents;
    std::vector<int> sizes;
    std::vector<int> ranks;
    DisjointSet(int _size) : parents(_size+1, -1), ranks(_size+1, 0), sizes(_size+1, 1) {}
    int Find(int node)
    {
        if(parents[node] == -1) return node;
        return parents[node] = Find(parents[node]);
    }
    void Union(int node1, int node2)
    {
        int root1 = Find(node1);
        int root2 = Find(node2);
        if(root1 == root2) return;
        if(ranks[root1] == ranks[root2])
        {
            ranks[root1]++;
            parents[root2] = root1;
            sizes[root1] += sizes[root2];
            sizes[root2] = 0;
        }
        else if(ranks[root1] > ranks[root2])
        {
            parents[root2] = root1;
            sizes[root1] += sizes[root2];
            sizes[root2] = 0;
        }
        else
        {
            parents[root1] = root2;
            sizes[root2] += sizes[root1];
            sizes[root1] = 0;
        }
    }
};

int main() 
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cin >> N >> M >> K;
    DisjointSet ds(N);
    for(int n = 1; n <= N; n++) std::cin >> c[n];
    for(int m = 0; m < M; m++)
    {
        std::cin >> a >> b;
        ds.Union(a, b);
    }
    for(int n = 1; n <= N; n++)
    {
        if(ds.Find(n) != n) c[ds.Find(n)] += c[n];
    }
    for(int n = 1; n <= N; n++)
    {
        //std::cout << ds.sizes[n] <<','<<V[ds.Find(n)] << ' ';
        if(ds.Find(n) != n) continue;
        for(int k = K-1; k - ds.sizes[n] >= 0; k--)
        {
            dp[k] = std::max(dp[k], dp[k-ds.sizes[n]] + c[n]);
        }
    }
    std::cout << dp[K-1];
    return 0;
}