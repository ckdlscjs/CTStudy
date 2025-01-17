#include <bits/stdc++.h>
int N, R, Q, a, b;
std::vector<int> graph[100'005];
bool visited[100'005];
int childs[100'005];
int DFS(int cur)
{
  visited[cur] = true;
  int ret = 1;
  for(const auto& iter : graph[cur])
  {
    if(visited[iter]) continue;
    childs[iter] = DFS(iter);
    ret += childs[iter];
  }
  return ret;
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> R >> Q;
  for(int n = 0; n < N-1; n++)
  {
    std::cin >> a >> b;
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  childs[R] = DFS(R);
  for(int q = 0; q < Q; q++)
  {
    std::cin >> a;
    std::cout << childs[a] << '\n';
  }
  return 0;
}