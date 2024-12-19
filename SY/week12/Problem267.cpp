#include <bits/stdc++.h>
using namespace std;
long long int N, sum, cnt;
bool NotPrime[4'000'005];
int main()
{
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
  std::cin >> N;
  NotPrime[0] = NotPrime[1] = true;
  for(int i = 2; i <= std::sqrt(N); i++)
  {
    for(int j = 2; i * j <= N; j++)
      NotPrime[i*j] = true;
  }
  long long int l = 2, r = 2;
  while(l <= r && l <= N)
  {
    //std::cout << l <<' ' << r << ' ' << sum <<  '\n';
    if(sum < N)
    {
      sum += r++;
      while(NotPrime[r]) r++;
    }
    else
    {
      if(sum == N) cnt++;
      sum -= l++;
      while(NotPrime[l]) l++;
    }
  }
  std::cout << cnt;
  return 0;
}

--------------------

#include <bits/stdc++.h>
long long int n, start, end, sum, cnt;
const int MaxN = 4'000'005;
bool NotPrime[MaxN];
std::vector<int> primes;
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    std::cin >> n;
    NotPrime[0] = NotPrime[1] = true;
    for(int i = 2; i <= MaxN; i++)
    {
      if(NotPrime[i])
        continue;
      primes.push_back(i);
      for(int j = 2; i*j <= MaxN; j++)
        NotPrime[i*j] = true;
    }
    while(end <= primes.size())
    {
      if(sum < n) sum += primes[end++];
      else sum -= primes[start++];
      if(sum == n) cnt++;
    }
    std::cout << cnt;
    return 0;
}

