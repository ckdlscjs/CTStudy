#include <bits/stdc++.h>
using namespace std;
const long long Mod = 1'000'000'007;
long long N;
std::vector<std::vector<long long>> Multiply(const std::vector<std::vector<long long>>& a, const std::vector<std::vector<long long>>& b)
{
    std::vector<std::vector<long long>> ret(2, std::vector<long long>(2, 0));
    for(int i = 0; i < 2; i++)
    {
        for(int j = 0; j < 2; j++)
        {
            for(int k = 0; k < 2; k++)
            {
                ret[i][j] += (a[i][k] * b[k][j]) % Mod;
            }
            ret[i][j] %= Mod;
        }
    }
    return ret;
}
std::vector<std::vector<long long>> Fibo(long long K)
{
    if(K <= 1) return {{1, 1}, {1, 0}};
    std::vector<std::vector<long long>> temp = Fibo(K/2);
    temp = Multiply(temp, temp);
    if(K % 2) temp = Multiply(temp, {{1, 1}, {1, 0}});
    return temp;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    std::vector<std::vector<long long>> ret = Fibo(N-1);
    std::cout << ret[0][0];
    return 0;
}
