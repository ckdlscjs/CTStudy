#include <bits/stdc++.h>
int N, M, arr[100'005], ans = INT_MAX;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  for(int i = 0; i < N; i++)
  {
    int lo = i-1, hi = N;
    while(lo + 1 < hi)
    {
      int mid = (lo + hi) / 2;
      int temp = arr[mid] - arr[i];
      if(M <= std::abs(temp) && std::abs(temp) < ans)
        ans = std::abs(temp);
      if(temp > M) hi = mid;
      else lo = mid;
    }
  }
  std::cout << ans;
  return 0;
}

---------------

#include <bits/stdc++.h>
int N, M, arr[100'005], ans = INT_MAX;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  int l = 0, r = 0;
  while(l < N && r < N)
  {
    int temp = arr[r] - arr[l];
    if(temp < M) r++;
    else
    {
        ans = std::min(ans, temp);
        l++;
    }
  }
  std::cout << ans;
  return 0;
}