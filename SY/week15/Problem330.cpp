#include <bits/stdc++.h>
int T, N;
std::string str;
struct Trie
{
  bool finish = false;
  Trie* nodes[10];
  Trie()
  {
    finish = false;
    for(int i = 0; i < 10; i++) nodes[i] = nullptr;
  }
  virtual ~Trie()
  {
    for(int i = 0; i < 10; i++)
      if(nodes[i])
        delete nodes[i];
  }
  void Insert(const std::string& str, int idx)
  {
    if(idx >= str.size())
    {
      finish = true;
      return;
    }
    int cur = str[idx] - '0';
    if(!nodes[cur]) nodes[cur] = new Trie();
    nodes[cur]->Insert(str, idx+1);
  }
  bool Find(const std::string& str, int idx)
  {
    if(idx >= str.size()) return false;
    if(finish) return true;
    int cur = str[idx] - '0';
    if(!nodes[cur]) return false;
    return nodes[cur]->Find(str, idx+1);
  }
};
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> T;
  for(int t = 0; t < T; t++)
  {
    std::cin >> N;
    Trie trie;
    std::vector<std::string> inputs;
    for(int n = 0; n < N; n++)
    {
      std::cin >> str;
      trie.Insert(str, 0);
      inputs.push_back(str);
    }
    bool ret = false;
    for(const auto& iter : inputs)
    {
      ret = trie.Find(iter, 0);
      if(ret) break;
    }
    std::cout << (ret ? "NO" : "YES") << '\n';
  }
 
  return 0;
}