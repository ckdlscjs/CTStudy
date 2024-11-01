#include <bits/stdc++.h>
using namespace std;
std::string input;
int M;
char order, ch;
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  std::cout.tie(nullptr);

  std::cin >> input;
  std::list<char> str;
  for(const auto& it : input) str.push_back(it);
  std::list<char>::iterator iter = str.end();
  std::cin >> M;
  for(int i = 0; i < M; i++)
  {
    std::cin >> order;
    if(order == 'L')
    {
      if(iter == str.begin())
        continue;
      iter--;
    }
    else if(order == 'D')
    {
      if(iter == str.end())
        continue;
      iter++;
    }
    else if(order == 'B')
    {
      if(iter == str.begin())
        continue;
      iter = str.erase(--iter);
    }
    else
    {
      std::cin >> ch;
      str.insert(iter, ch);
    }
  }
  for(const auto& ch : str) std::cout << ch;
  return 0;
}