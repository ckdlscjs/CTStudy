#include <bits/stdc++.h>
int N, M, arr[500'005], arr2[500'005];
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> M;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  std::sort(arr, arr+N);
  for(int i = 0; i < M; i++) std::cin >> arr2[i];
  std::sort(arr2, arr2+M);
  std::vector<int> res;
  int idx = 0;
  for(int i = 0; i < M; i++)
  {
    while(idx < N && arr[idx] < arr2[i])
      res.push_back(arr[idx++]);
    if(arr[idx] == arr2[i])
      idx++;
  }
  while(idx < N)
    res.push_back(arr[idx++]);
  std::cout << res.size() << '\n';
  if(res.empty())
    return 0;
  for(const auto& iter : res)
    std::cout << iter << ' ';
  return 0;
}