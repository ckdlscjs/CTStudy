#include <bits/stdc++.h>
using namespace std;
int N, dp[2][3];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    std::cin >> dp[0][0] >> dp[0][1] >> dp[0][2];
    for(int i = 1; i < N; i++)
    {
        std::cin >> dp[1][0] >> dp[1][1] >> dp[1][2];
        dp[1][0] += std::min(dp[0][1], dp[0][2]);
        dp[1][1] += std::min(dp[0][0], dp[0][2]);
        dp[1][2] += std::min(dp[0][0], dp[0][1]);
        dp[0][0] = dp[1][0];
        dp[0][1] = dp[1][1];
        dp[0][2] = dp[1][2];
    }
    std::cout << std::min({dp[1][0], dp[1][1], dp[1][2]});
    return 0;
}
