#include <bits/stdc++.h>
int T, N, K, D[1'005], X, Y, W;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> T;
  for(int t = 0; t < T; t++)
  {
    std::vector<int> dp(1'005, 0);
    std::vector<int> cnt(1'005, 0);
    std::vector<int> graph[1'005];
    std::cin >> N >> K;
    for(int n = 1; n <= N; n++)
    {
      std::cin >> D[n];
      dp[n] = D[n];
    }
    for(int k = 0; k < K; k++)
    {
      std::cin >> X >> Y;
      graph[X].push_back(Y);
      cnt[Y]++;
    }
    std::cin >> W;
    std::queue<int> q;
    for(int n = 1; n <= N; n++)
    {
      if(cnt[n] == 0)
        q.push(n);
    }
    for(int n = 1; n <= N; n++)
    {
      int cur = q.front();
      q.pop();
      for(const auto& iter : graph[cur])
      {
        dp[iter] = std::max(dp[iter], dp[cur] + D[iter]);
        if(--cnt[iter] <= 0)
          q.push(iter);
      }
    }
    std::cout << dp[W] << '\n';
  }
  return 0;
}