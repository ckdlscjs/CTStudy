#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;
int N, M, dp[105][105], a, b, c;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::fill_n(&dp[0][0], 105*105, INF);
    std::cin >> N >> M;
    for(int i = 1; i <= N; i++) dp[i][i] = 0;
    for(int m = 0; m < M; m++)
    {
        std::cin >> a >> b >> c;
        dp[a][b] = std::min(dp[a][b], c);
    }
    for(int k = 1; k <= N; k++)
    {
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                dp[i][j] = std::min(dp[i][j], dp[i][k] + dp[k][j]);
            }
        }
    }
    for(int i = 1; i <= N; i++)
    {
        for(int j = 1; j <= N; j++)
        {
            std::cout << (dp[i][j] == INF ? 0 : dp[i][j]) << ' ';
        }
        std::cout << '\n';
    }
    return 0;
}
