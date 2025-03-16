#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    int sum = 0;
    for(int i = 0; i < 8; i++)
    {
        int cur;
        std::cin >> cur;
        sum = sum*10 + cur;
    }
    std::cout << (sum == 12345678 ? "ascending" : sum == 87654321 ? "descending" : "mixed");
    return 0;
}