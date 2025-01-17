#include <bits/stdc++.h>
int N, M, a, b;
struct DisjointSet
{
  int parents[500'005];
  DisjointSet(int _size)
  {
    std::fill_n(parents, _size, -1);
  }
  int Find(int node)
  {
    if(parents[node] == -1)
      return node;
    return parents[node] = Find(parents[node]);
  }
  void Union(int node1, int node2)
  {
    int root1 = Find(node1);
    int root2 = Find(node2);
    if(root1 == root2) return;
    parents[root2] = root1;
  }
};
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  int N, M;
  std::cin >> N >> M;
  DisjointSet ds(N);
  for(int i = 0; i < M; i++)
  {
    std::cin >> a >> b;
    if(ds.Find(a) == ds.Find(b))
    {
      std::cout << i + 1;
      return 0;
    }
    ds.Union(a, b);
  }
  std::cout << 0;
  return 0;
}