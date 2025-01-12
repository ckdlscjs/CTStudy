#include <bits/stdc++.h>
int N, K, dp[500'005][2], t = 1;
std::queue<int> q;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> K;
  dp[N][t%2] = t;
  q.push(N);
  while(q.size())
  {
    if(K > 500'000) break;
    if(dp[K][t%2])
    {
      std::cout << t-1;
      return 0;
    }
    int len = q.size();
    for(int i = 0; i < len; i++)
    {
      int c = q.front();
      q.pop();
      for(const auto& iter : {c-1, c+1, c*2})
      {
        if(iter < 0 || iter > 500'000 || dp[iter][(t+1)%2]) continue;
        dp[iter][(t+1)%2] = t+1;
        q.push(iter);
      }
    }
    K += t;
    t++;
  }
  std::cout << -1;
  return 0;
}