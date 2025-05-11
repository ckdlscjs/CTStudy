#include <bits/stdc++.h>
using namespace std;
long long Mod = 1'000'000'000;
long long N, dp[105][10][1<<10];
long long Check(int n, int cur, int mask)
{
    if(n <= 0) return mask == (1<<10) - 1;
    long long& ret = dp[n][cur][mask];
    if(ret != -1) return ret;
    ret = 0;
    if(cur > 0) ret = (ret + Check(n-1, cur-1, mask | (1 << (cur-1)))) % Mod;
    if(cur < 9) ret = (ret + Check(n-1, cur+1, mask | (1 << (cur+1)))) % Mod;
    return ret;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::memset(dp, -1, sizeof(dp));
    std::cin >> N;
    long long res = 0;
    for(int i = 1; i <= 9; i++) res = (res + Check(N-1, i, 1 << i)) % Mod;
    std::cout << res;
    return 0;
}
