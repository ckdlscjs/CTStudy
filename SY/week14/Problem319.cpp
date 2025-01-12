#include <bits/stdc++.h>
using namespace std;
int arr[25][25];
int n;
int res = 987654321;
void check(int cnt, int idx, int mask)
{
  if(cnt == n/2)
  {
    int sum_start = 0;
    int sum_link = 0;
    for(int i = 0; i < n; i++)
    {
      for(int j = 0; j < n; j ++)
      {
        if((mask & 1 << i) && (mask & 1 << j)) sum_start += arr[i][j];
        else if(!(mask & 1 << i) && !(mask & 1 << j)) sum_link += arr[i][j];
      }
    }
    res = std::min(res, std::abs(sum_start - sum_link));
    return;
  }
  if(cnt > n / 2)
    return;
  if(idx >= n)
    return;
  check(cnt, idx+1, mask);
  check(cnt+1, idx+1, mask | 1 << idx);
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> n;
  for(int i = 0; i < n; i++)
    for(int j = 0; j < n; j++)
      std::cin >> arr[i][j];
  check(0, 0, 0);
  std::cout << res;
  return 0;
}