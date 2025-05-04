#include <bits/stdc++.h>
using namespace std;
int N, arr[100'005], res = 2'000'000'005;
std::pair<int, int> output;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int n = 0; n < N; n++) std::cin >> arr[n];
    int l = 0, r = N-1;
    while(l < r)
    {
        int sum = arr[l] + arr[r];
        if(std::abs(sum) < res)
        {
            res = std::abs(sum);
            output.first = arr[l];
            output.second = arr[r];
        }
        if(sum <= 0) l++;
        else r--;
    }
    std::cout << output.first << ' ' << output.second;
    return 0;
}
