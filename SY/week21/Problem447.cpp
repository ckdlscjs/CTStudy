#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    int T;
    std::cin >> T;
    for(int t = 0; t < T; t++)
    {
        int N;
        std::cin >> N;
        std::string str;
        std::cin >> str;
        for(int i = 0; i < str.size(); i++)
            for(int n = 0; n < N; n++)
                std::cout << str[i];
        std::cout << '\n';
    }
    return 0;
}