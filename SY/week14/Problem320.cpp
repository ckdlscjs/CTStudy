#include <bits/stdc++.h>
int N, L, arr_hor[105][105], arr_ver[105][105];
int Check(int (*arr)[105])
{
  int res = 0;
  for(int i = 0; i < N; i++)
  {
    int cnt = 1;
    int cur = arr[i][0];
    int j = 1;
    for(j; j < N; j++)
    {
      if(arr[i][j] == cur) cnt++;
      else if(cur + 1 == arr[i][j] && j - L >= 0 && cnt >= L)
      {
        cur = arr[i][j];
        cnt = 1;
      }
      else if(cur - 1 == arr[i][j] && j - 1 + L <= N-1 && cnt >= 0)
      {
        cur = arr[i][j];
        cnt = -L + 1;
      }
      else
      {
        cnt = -1;
        break;
      }
    }
    if(j >= N-1 && cnt >= 0)
      res++;
  }
  return res;
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> L;
  for(int i = 0; i < N; i++)
  {
    for(int j = 0; j < N; j++)
    {
      std::cin >> arr_hor[i][j];
      arr_ver[j][i] = arr_hor[i][j];
    }
  }
  std::cout << Check(arr_hor)+Check(arr_ver);
  return 0;
}