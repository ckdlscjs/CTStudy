#include <bits/stdc++.h>
using namespace std;
int N, S, psum[100'005];
bool Check(int length)
{
    if(length > N) return true;
    for(int i = 0; i + length <= N; i++)
    {
        if(psum[i+length] - psum[i] >= S) return true;
    }
    return false;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> S;
    for(int n = 1; n <= N; n++)
    {
        std::cin >> psum[n];
        psum[n] += psum[n-1];
    }
    if(psum[N] < S)
    {
        std::cout << 0;
        return 0;
    }
    int lo = 0, hi = 100'001;
    while(lo + 1 < hi)
    {
        int mid = (lo + hi) / 2;
        if(Check(mid)) hi = mid;
        else lo = mid;
    }
    std::cout << hi;
    return 0;
}
