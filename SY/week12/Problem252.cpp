#include <bits/stdc++.h>
int M, N, arr[1'000'005];
bool Check(int mid)
{
  int cnt = 0;
  for(int i = 0; i < N; i++)
    cnt += arr[i] / mid;
  return cnt >= M;
}
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> M >> N;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  int lo = 0, hi = 1'000'000'005;
  while(lo + 1 < hi)
  {
    int mid = (lo + hi) / 2;
    if(Check(mid)) lo = mid;
    else hi = mid;
  }
  std::cout << lo;
  return 0;
}