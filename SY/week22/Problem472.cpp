#include <bits/stdc++.h>
using namespace std;
int A, B;
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> A >> B;
  int large = std::max(A, B);
  int small = std::min(A, B);
  while(large % small)
  {
    int temp = large % small;
    large = small;
    small = temp;
  }
  std::cout << small << '\n' << A*B/small;
  return 0;
}