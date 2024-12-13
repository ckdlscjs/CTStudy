#include <bits/stdc++.h>
using namespace std;
struct compare
{
  bool operator()(const std::pair<int, int>& a, const std::pair<int, int>& b)
  {
    return a.second == b.second ? a.first > b.first : a.second > b.second;
  }
};
int N, cnt = 1;
std::pair<int, int> val;
std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, compare> pq;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++)
  {
    std::cin >> val.first >> val.second;
    pq.push({val.first, val.second});
  }
  val = pq.top();
  pq.pop();
  while(pq.size())
  {
    if(pq.top().first >= val.second)
    {
      val = pq.top();
      cnt++;
    }
    pq.pop();
  }
  std::cout << cnt;
  return 0;
}