#include <bits/stdc++.h>
using namespace std;
int N, K, val, cnt;
std::priority_queue<int, std::vector<int>, std::less<int>> pq;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> K;
  for(int i = 0; i < N; i++)
  {
    std::cin >> val;
    pq.push(val);
  }
  while(pq.size() && K)
  {
    if(pq.top() > K)
    {
      pq.pop();
      continue;
    }
    cnt += K / pq.top();
    K %= pq.top();
    pq.pop();
  }
  std::cout << cnt;
  return 0;
}