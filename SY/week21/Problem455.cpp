#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    int y;
    std::cin >> y;
    std::cout << ((y % 4 == 0 && y % 100) || (y % 400 == 0)) ? 1 : 0;
    return 0;
}