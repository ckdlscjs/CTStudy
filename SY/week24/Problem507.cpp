#include <bits/stdc++.h>
using namespace std;
long long int N, B;
std::vector<std::vector<long long int>> Multiply(const std::vector<std::vector<long long int>>& mat1, const std::vector<std::vector<long long int>>& mat2)
{
    std::vector<std::vector<long long int>> ret(N, std::vector<long long int>(N, 0));
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            for(int k = 0; k < N; k++)
            {
                ret[i][j] += (mat1[i][k] * mat2[k][j]) % 1'000;
                ret[i][j] %= 1'000;
            }
        }
    }
    return ret;
}
std::vector<std::vector<long long int>> Power(const std::vector<std::vector<long long int>>& mat, long long int K)
{
    if(K <= 1) return mat;
    std::vector<std::vector<long long int>> half = Power(mat, K/2);
    std::vector<std::vector<long long int>> ret = Multiply(half, half);
    if(K % 2)
        ret = Multiply(ret, mat);
    return ret;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> B;
    std::vector<std::vector<long long int>> mat(N, std::vector<long long int>(N));
    for(int i = 0; i < N; i++)
        for(int j = 0; j < N; j++)
            std::cin >> mat[i][j];
    std::vector<std::vector<long long int>> ans = Power(mat, B);
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < N; j++)
        {
            std::cout << ans[i][j] % 1'000 << ' ';
        }
        std::cout << '\n';
    }
    return 0;
}
