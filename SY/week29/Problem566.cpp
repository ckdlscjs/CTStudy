#include <bits/stdc++.h>
using namespace std;
int maxCnt = 0;
long long A, B, dp[64];
long long Check(long long num)
{
    long long ret = 0;
    for(int i = maxCnt+1; i >= 0; i--)
    {
        if(num & (1LL << i))
        {
            ret += dp[i] + (num - (1LL << i) + 1);
            num -= (1LL << i);
        }
    }
    return ret;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    dp[1] = 1;
    for(int cnt = 63; cnt >= 0; cnt--)
        if((long long)1e16 & (1LL << cnt))
        {
            maxCnt = cnt;
            break;
        }
    for(int i = 2; i < maxCnt+1; i++) dp[i] = (1LL << (i-1)) + dp[i-1] * 2;
    std::cin >> A >> B;
    std::cout << Check(B) - Check(A-1);
    return 0;
}