#include <bits/stdc++.h>
std::string str;
std::stack<char> st;
std::vector<char> results;
std::unordered_map<char, int> orders;
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  orders['+'] = 0;
  orders['-'] = 0;
  orders['*'] = 1;
  orders['/'] = 1;
  orders['('] = 2;
  orders[')'] = 2;
  std::cin >> str;
  for(const auto& iter : str)
  {
    if(isalpha(iter))
      results.push_back(iter);
    else
    {
      if(st.empty() || iter == '(')
        st.push(iter);
      else if(iter == ')')
      {
        while(st.size() && st.top() != '(')
        {
          results.push_back(st.top());
          st.pop();
        }
        st.pop();
      }
      else
      {
        while(st.size() && st.top() != '(' && orders[st.top()] >= orders[iter])
        {
          results.push_back(st.top());
          st.pop();
        }
        st.push(iter);
      }
    }
  }
   while(st.size())
  {
    results.push_back(st.top());
    st.pop();
  }
  for(const auto& iter : results)
    std::cout << iter;
  return 0;
}