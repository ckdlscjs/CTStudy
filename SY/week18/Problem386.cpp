#include <bits/stdc++.h>
using namespace std;
long long int N, P, Q;
std::unordered_map<long long int, long long int> chks;
long long int Check(long long int cur)
{
  if(chks.find(cur) != chks.end()) return chks[cur];
  return chks[cur] = Check(cur/P) + Check(cur/Q);
}
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  chks[0] = 1;
  std::cin >> N >> P >> Q;
  std::cout << Check(N);
  return 0;
}