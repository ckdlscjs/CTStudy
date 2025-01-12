#include <bits/stdc++.h>
int N, dp[100'005];
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 1; i <= N; i++)
  {
    dp[i] = i;
    for(int j = 1; j * j <= i; j++)
      dp[i] = std::min(dp[i], dp[i - j*j] + 1);
  }
  std::cout << dp[N];
  return 0;
}