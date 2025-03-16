#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    int N;
    std::cin >> N;
    for(int n = 0; n < N; n++)
    {
        std::string str;
        std::cin >> str;
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < str.size(); i++)
        {
            cnt = (str[i] == 'O' ? cnt + 1 : 0);
            sum += cnt;
        }
        std::cout << sum <<'\n';
    }
    return 0;
}