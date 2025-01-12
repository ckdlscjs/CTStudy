#include <bits/stdc++.h>
int N, M, S, E, arr[2005], dp[2005][2005];
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  for(int i = N-1; i >= 0; i--)
  {
    for(int j = i; j < N; j++)
    {
      if(arr[i] == arr[j])
        dp[i][j] = dp[i+1][j-1];
      else
        dp[i][j] = std::min(dp[i+1][j], dp[i][j-1]) + 1;
    }
  }
  std::cin >> M;
  for(int i = 0; i < M; i++)
  {
    std::cin >> S >> E;
    std::cout << (dp[S-1][E-1] ? 0 : 1) << '\n';
  }
  return 0;
}