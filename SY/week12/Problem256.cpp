#include <bits/stdc++.h>
int N, arr[10'005];
long long int cnt;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  for(int i = 0; i < N; i++)
  {
    for(int j = i+1; j < N; j++)
    {
      int lo = j, hi = N, lb, ub;
      while(lo + 1 < hi)
      {
        int mid = (lo + hi) / 2;
        if(arr[mid] + arr[i] + arr[j] >= 0) hi = mid;
        else lo = mid;
      }
      lb = hi;
      lo = j, hi = N;
      while(lo + 1 < hi)
      {
        int mid = (lo + hi) / 2;
        if(arr[mid] + arr[i] + arr[j] > 0) hi = mid;
        else lo = mid;
      }
      ub = hi;
      cnt += ub - lb;
    }
  }
  std::cout << cnt;
  return 0;
}