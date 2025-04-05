#include <bits/stdc++.h>
using namespace std;
const int INF = 15*100+5;
int N, M, R, dp[105][105], items[105], a, b, l;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::fill_n(&dp[0][0], 105*105, INF);
    std::cin >> N >> M >> R;
    for(int i = 1; i <= N; i++)
    {
        std::cin >> items[i];
        dp[i][i] = 0;
    }
    for(int r = 0; r < R; r++)
    {
        std::cin >> a >> b >> l;
        dp[a][b] = l;
        dp[b][a] = l;
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
    int ret = 0;
    for(int i = 1; i <= N; i++)
    {
        int sum = 0;
        for(int j = 1; j <= N; j++)
        {
            sum += dp[i][j] <= M ? items[j] : 0;
        }
        ret = std::max(ret, sum);
    }
    std::cout << ret;
    return 0;
}
