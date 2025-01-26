#include <bits/stdc++.h>
int N, K, bags[300'005];
long long int sum;
std::pair<int, int> jewels[300'005];
std::priority_queue<int, std::vector<int>, std::less<int>> pq;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> K;
  for(int n = 0; n < N; n++) std::cin >> jewels[n].first >> jewels[n].second;
  for(int k = 0; k < K; k++) std::cin >> bags[k];
  std::sort(jewels, jewels+N, std::less<>());
  std::sort(bags, bags+K, std::less<>());
  int n = 0;
  for(int k = 0; k < K; k++)
  {
    while(n < N && jewels[n].first <= bags[k]) pq.push(jewels[n++].second);
    if(pq.size())
    {
      sum += pq.top();
      pq.pop();
    }
  }
  std::cout << sum;
  return 0;
}