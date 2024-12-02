#include <bits/stdc++.h>
using namespace std;
int n;
int main() 
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> n;
  int cnt = 0;
  for(int i = 0; i < n; i++)
  {
    std::string str;
    std::cin >> str;
    std::stack<char> st;
    for(const auto& iter : str)
    {
      if(st.empty() || st.top() != iter)
        st.push(iter);
      else
        st.pop();
    }
    if(st.empty())
      cnt++;
  }
  std::cout << cnt;
  return 0;
}