#include <bits/stdc++.h>
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  std::cout.tie(nullptr);
  long long int A, B;
  std::cin >> A >> B;
  if(A == B)
  {
    std::cout << 0;
    return 0;
  }
  std::cout << std::abs(A-B) - 1 << '\n';
  for(long long int i = std::min(A, B) + 1; i < std::max(A, B); i++)
    std::cout << i << ' ';
  return 0;
}