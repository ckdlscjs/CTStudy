#include <bits/stdc++.h>
using namespace std;
int N, arr[1'005], dp_lr[1'005], dp_rl[1'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int n = 0; n < N; n++) std::cin >> arr[n];
    for(int i = 0; i < N; i++)
    {
        dp_lr[i] = 1;
        for(int j = 0; j < i; j++)
        {
            if(arr[j] < arr[i] && dp_lr[j] >= dp_lr[i])
                dp_lr[i] = dp_lr[j] + 1;
        }
    }
    for(int i = N-1; i >= 0; i--)
    {
        dp_rl[i] = 1;
        for(int j = N-1; j >= 0; j--)
        {
            if(arr[j] < arr[i] && dp_rl[j] >= dp_rl[i])
                dp_rl[i] = dp_rl[j] + 1;
        }
    }
    int res = 0;
    for(int i = 0; i < N; i++)
        res = std::max(res, dp_lr[i] + dp_rl[i] - 1);
    std::cout << res;
    return 0;
}
