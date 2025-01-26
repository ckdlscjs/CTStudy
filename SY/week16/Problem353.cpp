#include <bits/stdc++.h>
int N, sum, d, r;
std::vector<int> inputs[200'005];
std::priority_queue<int, std::vector<int>, std::less<int>> pq;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int n = 0; n < N; n++)
  {
    std::cin >> d >> r;
    inputs[d].push_back(r);
  }
  for(int n = N; n >= 1; n--)
  {
    for(const auto& iter : inputs[n]) pq.push(iter);
    if(pq.size())
      sum += pq.top(), pq.pop();
  }
  std::cout << sum;
  return 0;
}

-----------

#include <bits/stdc++.h>
int n, sum;
std::pair<int, int> arr[200005];
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    std::cin >> n;
    for(int i = 0; i < n; i++)
    {
      std::cin >> arr[i].first >> arr[i].second;
      sum += arr[i].second;
    }
      
    std::sort(arr, arr+n, std::less<>());
    std::priority_queue<int, std::vector<int>, std::greater<int>> pq;
    for(int i = 0; i < n; i++)
    {
      pq.push(arr[i].second);
      if(pq.size() > arr[i].first)
      {
        sum -= pq.top();
        pq.pop();
      }
    }
    std::cout << sum;
    return 0;
}