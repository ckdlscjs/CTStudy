#include <bits/stdc++.h>
using namespace std;
std::string str, pat, cur;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> str >> pat;
    for(int i = 0; i < str.size(); i++)
    {
        cur += str[i];
        while(cur.size() >= pat.size() && cur.substr(cur.size() - pat.size()) == pat)
        {
            cur.erase(cur.size() - pat.size());
        }
    }
    std::cout << (cur.size() ? cur : "FRULA");
}
