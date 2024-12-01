#include <bits/stdc++.h>
int N, res, dp[505][505];
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 1; i <= N; i++)
  {
    for(int j = 1; j <= i; j++)
    {
      std::cin >> dp[i][j];
      dp[i][j] += std::max(dp[i-1][j-1], dp[i-1][j]);
      res = std::max(res, dp[i][j]);
    }
  }
  std::cout << res;
  return 0;
}