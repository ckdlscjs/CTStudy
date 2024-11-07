#include <bits/stdc++.h>
int N, L, val;
std::deque<std::pair<int, int>> dq;
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> L;
  for(int i = 0; i < N; i++)
  {
    std::cin >> val;
    while(dq.size() && dq.front().second + L <= i)
      dq.pop_front();
    while(dq.size() && dq.back().first > val)
      dq.pop_back();
    dq.push_back({val, i});
    std::cout << dq.front().first << ' ';
  }
  return 0;
}
//덱
#include <bits/stdc++.h>
int N, L, val;
std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> pq;
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> L;
  for(int i = 0; i < N; i++)
  {
    std::cin >> val;
    pq.push({val, i});
    while(pq.top().second + L <= i)
      pq.pop();
    std::cout << pq.top().first << ' ';
  }
  return 0;
}
//우선순위큐

