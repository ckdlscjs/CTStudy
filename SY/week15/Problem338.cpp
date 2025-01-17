#include <bits/stdc++.h>
int N, a, b;
char I;
struct DisjointSet
{
  int parents[1'000'005];
  int sizes[1'000'005];
  DisjointSet(int _size)
  {
    std::fill_n(parents, _size, -1);
    std::fill_n(sizes, _size, 1);
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
    sizes[root1] += sizes[root2];
    sizes[root2] = 0;
  }
};
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  DisjointSet ds(1'000'000);
  std::cin >> N;
  for(int i = 0; i < N; i++)
  {
    std::cin >> I;
    if(I == 'I')
    {
      std::cin >> a >> b;
      ds.Union(a, b);
    }
    else
    {
      std::cin >> a;
      std::cout << ds.sizes[ds.Find(a)] << '\n';
    }
  }
  return 0;
}