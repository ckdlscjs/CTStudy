#include <bits/stdc++.h>
int T, N;
std::pair<int, int> operator+(const std::pair<int, int>& lhs, const std::pair<int, int>& rhs) 
{
  return {lhs.first + rhs.first, lhs.second + rhs.second};
}
std::unordered_map<int, std::pair<int, int>> fibos;
std::pair<int, int> Fibo(int n)
{
  if(fibos.find(n) != fibos.end()) return fibos[n];
  if(n <= 0) return fibos[0] = {1, 0};
  if(n <= 1) return fibos[1] = {0, 1};
  return fibos[n] = Fibo(n-1) + Fibo(n-2);
}
int main(void)
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> T;
  Fibo(40);
  for(int t = 0; t < T; t++)
  {
    std::cin >> N;
    std::cout << Fibo(N).first << ' ' << Fibo(N).second<< '\n';
  }
 
  return 0;
}