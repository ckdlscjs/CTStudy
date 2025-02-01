#include <bits/stdc++.h>
const int dy[] = {0, 0, -1, 1};
const int dx[] = {-1, 1, 0, 0};
int N, M, arr[105][105], costs[105][105];
std::priority_queue<std::pair<int, std::pair<int, int>> , std::vector<std::pair<int, std::pair<int, int>>>, std::greater<std::pair<int, std::pair<int, int>>>> pq;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> M >> N;
  for(int n = 0; n < N; n++)
  {
    std::string str;
    std::cin >> str;
    for(int m = 0; m < M; m++)
    {
      arr[n][m] = str[m] - '0';
    }
  }
  costs[0][0] = 1;
  pq.push({costs[0][0], {0, 0}});
  while(pq.size())
  {
    auto iter = pq.top();
    pq.pop();
    int cc = iter.first;
    int cy = iter.second.first;
    int cx = iter.second.second;
    for(int dir = 0; dir < 4; dir++)
    {
      int ny = cy + dy[dir];
      int nx = cx + dx[dir];
      if(ny < 0 || nx < 0 || ny >= N || nx >= M || costs[ny][nx]) continue;
      costs[ny][nx] = costs[cy][cx] + arr[ny][nx];
      pq.push({costs[ny][nx],{ny, nx}});
    }
  }
  std::cout << costs[N-1][M-1] - 1;
  return 0;
}