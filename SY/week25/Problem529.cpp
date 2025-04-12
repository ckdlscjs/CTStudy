#include <bits/stdc++.h>
using namespace std;
int T, N, arr[2][100'005], dp[2][100'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> T;
    for(int t = 0; t < T; t++)
    {
        std::cin >> N;
        std::memset(dp, 0, sizeof(dp));
        for(int i = 0; i < 2; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                std::cin>> arr[i][j];
            }
        }
        for(int j = 1; j <= N; j++)
        {
            dp[0][j] = std::max(dp[0][j-1], dp[1][j-1] + arr[0][j]);
            dp[1][j] = std::max(dp[1][j-1], dp[0][j-1] + arr[1][j]);
        }
        std::cout << std::max(dp[0][N], dp[1][N]) << '\n';
    }
    
    return 0;
}
