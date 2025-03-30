/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
int N;
std::string str;
std::vector<std::string> words;
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cin >> N;
    for(int n = 0; n < N; n++)
    {
        std::cin >> str;
        words.push_back(str);
    }
    std::sort(words.begin(), words.end());
    words.erase(std::unique(words.begin(), words.end()), words.end());
    std::sort(words.begin(), words.end(), [](const std::string& a, const std::string& b)->bool{
        return a.size() == b.size() ? a < b : a.size() < b.size();
    });
    for(const auto& iter : words)
        std::cout << iter << '\n';
    return 0;
}