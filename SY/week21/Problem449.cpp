#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    std::unordered_set<int> chks;
    for(int i = 0; i < 10; i++)
    {
        int cur;
        std::cin >> cur;
        chks.insert(cur % 42);
    }
    std::cout << chks.size();
    return 0;
}