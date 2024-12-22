#include <bits/stdc++.h>
using namespace std;
int N, K, arr[200'005], e, len;
std::unordered_map<int, int> chks;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N >> K;
  for(int i = 0; i < N; i++) std::cin >> arr[i];
  for(int s = 0; s < N; s++)
  {
    while(chks[arr[e]] < K && e < N) chks[arr[e++]]++;
    len = std::max(e-s, len);
    chks[arr[s]]--;
  }
  std::cout << len;
  return 0;
}