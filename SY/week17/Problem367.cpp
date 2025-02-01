#include <bits/stdc++.h>
int N, M, dist[255][255], u, v, b, K;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  std::fill_n(&dist[0][0], 255*255, 987654321);
  for(int i = 1; i <= N; i++) dist[i][i] = 0;
  for(int m = 0; m < M; m++)
  {
    std::cin >> u >> v >> b;
    dist[v][u] = 0;
    dist[u][v] = 0;
    if(b == 0)
      dist[v][u] = 1;
  }
  for(int k = 1; k <= N; k++)
  {
    for(int i = 1; i <= N; i++)
    {
      for(int j = 1; j <= N; j++)
      {
        dist[i][j] = std::min(dist[i][j], dist[i][k] + dist[k][j]);
      }
    }
  }
  std::cin >> K;
  for(int k = 0; k < K; k++)
  {
    std::cin >> u >> v;
    std::cout << dist[u][v] << '\n';
  }
  return 0;
}