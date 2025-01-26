#include <bits/stdc++.h>
int N, Q, arr[500'005], order, x, cur;
std::set<int> keys;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> Q;
  for(int n = 0; n < N; n++)
  {
    std::cin >> arr[n];
    if(arr[n])
      keys.insert(n);
  }
  for(int q = 0; q < Q; q++)
  {
    std::cin >> order;
    if(order == 1)
    {
      std::cin >> x;
      x--;
      if(arr[x])
        keys.erase(x);
      else
        keys.insert(x);
      arr[x] = !arr[x];
    }
    else if(order == 2)
    {
      std::cin >> x;
      cur += x;
      cur %= N;
    }
    else
    {
      if(arr[cur])
      {
        std::cout << 0 <<'\n';
      }
      else if(keys.empty())
      {
        std::cout << -1 <<'\n';
      }
      else
      {
        auto pos = keys.lower_bound(cur);
        if(pos == keys.end())
          std::cout << (N-cur) + (*keys.begin()) << '\n';
        else
          std::cout << (*pos) - cur << '\n';
      }
    }
  }
  
  return 0;
}