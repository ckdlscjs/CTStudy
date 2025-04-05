#include <bits/stdc++.h>
using namespace std;
int N, K, dp[105][100'005];
std::pair<int, int> goods[100'005];
int Check(int idx, int weight)
{
    if(idx >= N || weight <= 0) return 0;
    int& ret = dp[idx][weight];
    if(ret != -1) return ret;
    ret = Check(idx+1, weight);
    if(weight - goods[idx].first >= 0)
        ret = std::max(ret, Check(idx+1, weight - goods[idx].first) + goods[idx].second);
    return ret;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> K;
    for(int n = 0; n < N; n++) std::cin >> goods[n].first >> goods[n].second;
    std::memset(dp, -1, sizeof(dp));
    std::cout << Check(0, K);
    return 0;
}
