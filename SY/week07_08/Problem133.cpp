#include <bits/stdc++.h>
const int dy[] = {0, 0, 1, -1};
const int dx[] = {1, -1, 0, 0};
int T, M, N, K, X, Y, arr[55][55];
bool visited[55][55];
void DFS(int i, int j)
{
  visited[i][j] = true;
  for(int dir = 0; dir < 4; dir++)
  {
    int ny = i + dy[dir];
    int nx = j + dx[dir];
    if(ny < 0 || nx < 0 || ny >= N || nx >= M || !arr[ny][nx] || visited[ny][nx]) continue;
    DFS(ny, nx);
  }
}
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> T;
  for(int t = 0; t < T; t++)
  {
    std::cin >> M >> N >> K;
    std::memset(arr, 0, sizeof(arr));
    std::memset(visited, false, sizeof(visited));
    for(int i = 0; i < K; i++)
    {
      std::cin >> X >> Y;
      arr[Y][X] = 1;
    }
    int cnt = 0;
    for(int i = 0; i < N; i++)
    {
      for(int j = 0; j < M; j++)
      {
        if(visited[i][j] || !arr[i][j]) continue;
        DFS(i, j);
        cnt++;
      }
    }
    std::cout << cnt << '\n';
  }
  return 0;
}