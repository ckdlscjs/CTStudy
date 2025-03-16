#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    int H, M;
    std::cin >> H >> M;
    int t = H*60 + M;
    t -= 45;
    if(t < 0)
        t += 24 * 60;
    std::cout << t / 60 << ' ' << t % 60; 
    return 0;
}