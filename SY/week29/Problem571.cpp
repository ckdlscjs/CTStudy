#include <bits/stdc++.h>
using namespace std;
int dp[2'505][2'505], cnt[2505];
std::string str;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> str;
    for(int i = str.size(); i >= 1; i--)
    {
        for(int j = i; j <= str.size(); j++)
        {
            if(i == j) dp[i][j] = 1;
            else if(str[i-1] == str[j-1]) dp[i][j] = dp[i+1][j-1] + 2;
            else dp[i][j] = std::max(dp[i+1][j], dp[i][j-1]);
        }
    }
    
    cnt[0] = 0;
    for(int j = 1; j <= str.size(); j++)
    {
        cnt[j] = str.size();
        for(int i = 1; i <= j; i++)
        {
            if(dp[i][j] == j - i + 1)
                cnt[j] = std::min(cnt[j], cnt[i-1] + 1);
        }
    }
    std::cout << cnt[str.size()];
    return 0;
}
