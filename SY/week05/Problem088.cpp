#include <bits/stdc++.h>
int N, Y, M, T;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  std::cout.tie(nullptr);
  std::cin >> N;
  for(int i = 0; i < N; i++)
  {
    std::cin >> T;
    Y += (T/30 + 1) * 10;
    M += (T/60 + 1) * 15;
  }
  if(Y == M)
    std::cout << "Y M " << M;
  else if(Y < M)
    std::cout << "Y " << Y;
  else
    std::cout << "M " << M;
  return 0;
}