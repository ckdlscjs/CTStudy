#include <bits/stdc++.h>
int N;
struct Trie
{
  int cnt;
  Trie* nodes[26];
  Trie()
  {
    cnt = 1;
    std::fill_n(nodes, 26, nullptr);
  }
  virtual ~Trie()
  {
    for(int i = 0; i < 26; i++)
      if(nodes[i])
        delete nodes[i];
  }
  int Insert(const std::string& str, int idx, int& ret)
  {
    if(idx >= str.size()) return cnt++;
    int cur = str[idx] - 'a';
    if(!nodes[cur])
    { 
      ret = std::min(ret, idx);
      nodes[cur] = new Trie();
    }
    return nodes[cur]->Insert(str, idx+1, ret);
  }
};
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  Trie trie;
  for(int n = 0; n < N; n++)
  {
    std::string str;
    std::cin >> str;
    int ret = str.size()-1;
    int cnt = trie.Insert(str, 0, ret);
    for(int i = 0; i <= ret; i++)
      std::cout << str[i];
    if(cnt >= 2)
      std::cout << cnt;
    std::cout << '\n';
  }
 
  return 0;
}