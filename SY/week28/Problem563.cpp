#include <bits/stdc++.h>
using namespace std;
const int MaxN = 4'000'005;
bool NotPrime[MaxN];
std::vector<int> primes;
int N, res;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int i = 2; i <= MaxN; i++)
    {
        if(NotPrime[i]) continue;
        primes.push_back(i);
        for(int j = 2; i*j <= MaxN; j++)
            NotPrime[i*j] = true;
    }
    int l = 0, r = 0, sum = 0;
    while(l <= r && r < primes.size())
    {
        sum += primes[r];
        if(N <= sum)
        {
            //std::cout << sum <<' ' << primes[l] << ' ' << primes[r] << '\n';
            if(N == sum) res++;
            sum -= primes[l++];
            sum -= primes[r];
        }
        else
        {
            r++;
        }
    }
    std::cout << res;
    return 0;
}
