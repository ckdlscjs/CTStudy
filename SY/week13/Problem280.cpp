#include <bits/stdc++.h>
const int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
int N, vals[2505], sy, sx, len, l, r, kcnt, res = INT_MAX;
std::pair<char, int> arr[55][55];
bool visited[55][55];
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
  {
    std::string str;
    std::cin >> str;
    for(int j = 0; j < N; j++)
    {
      arr[i][j].first = str[j];
      if(arr[i][j].first == 'P')
      {
        sy = i;
        sx = j;
      }
      else if(arr[i][j].first == 'K')
      {
        kcnt++;
      }
    }
  }
  for(int i = 0; i < N; i++)
  {
    for(int j = 0; j < N; j++)
    {
      std::cin >> arr[i][j].second;
      vals[i*N + j] = arr[i][j].second;
    }
  }
  len = N*N;
  std::sort(vals, vals+len);
  len = std::unique(vals, vals+len) - vals;
  l = 0;
  r = 0;
  while(l <= r && r < len)
  {
    if(arr[sy][sx].second > vals[r])
    {
      r++;
      continue;
    }
    int resmax = 0, resmin = INT_MAX, curk = 0;
    visited[sy][sx] = true;
    std::queue<std::pair<int, int>> q;
    q.push({sy, sx});
    while(q.size())
    {
      auto iter = q.front();
      q.pop();
      if(arr[iter.first][iter.second].first == 'K')
        curk++;
      resmax = std::max(resmax, arr[iter.first][iter.second].second);
      resmin = std::min(resmin, arr[iter.first][iter.second].second);
      for(int dir = 0; dir < 8; dir++)
      {
        int ny = iter.first + dy[dir];
        int nx = iter.second + dx[dir];
        if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || !(vals[l] <= arr[ny][nx].second && arr[ny][nx].second <= vals[r])) continue;
        visited[ny][nx] = true;
        q.push({ny, nx});
      }
    }
    if(curk >= kcnt)
    {
      res = std::min(res, resmax - resmin);
      l++;
    }
    else
    {
      r++;
    }
    std::memset(visited, false, sizeof(visited));
  }
  std::cout << res;
  return 0;
}