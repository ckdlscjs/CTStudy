#include <bits/stdc++.h>
using namespace std;
int tri[3];
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  while(std::cin >> tri[0] >> tri[1] >> tri[2] && tri[0]|tri[1]|tri[2])
  {
    std::sort(tri, tri+3, std::less<>());
    std::cout << (tri[0]*tri[0] + tri[1]*tri[1] == tri[2]*tri[2] ? "right" : "wrong") << '\n';
  }
  return 0;
}