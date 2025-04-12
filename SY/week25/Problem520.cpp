#include <bits/stdc++.h>
using namespace std;
int N, arr[1'005], dp[1'005], res;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int i = 0; i < N; i++)
    {
        std::cin >> arr[i];
        dp[i] = 1;
        for(int j = 0; j < i; j++)
        {
            if(arr[i] > arr[j] && dp[j] >= dp[i])
                dp[i] = dp[j] + 1;
        }
        res = std::max(res, dp[i]);
    }
    std::cout << res;
    return 0;
}
