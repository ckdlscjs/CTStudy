#include <bits/stdc++.h>
int N, S, arr[100'005];
bool Check(int len)
{
  if(N < len) return true;
  for(int i = N; i-len >= 0; i--)
    if(arr[i] - arr[i-len] >= S) return true;
  return false;
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> S;
  for(int i = 1; i <= N; i++)
  {
    std::cin >> arr[i];
    arr[i] += arr[i-1];
  }
  if(arr[N] < S)
  {
    std::cout << 0;
    return 0;
  }
  int lo = 0, hi = 100'001;
  while(lo + 1 < hi)
  {
    int len = (lo + hi) / 2;
    if(Check(len)) hi = len;
    else lo = len;
  }
  std::cout << hi;
  return 0;
}