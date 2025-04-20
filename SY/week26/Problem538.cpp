#include <bits/stdc++.h>
using namespace std;
int N, K, dist[100'005], cnt;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::fill_n(&dist[0], 100'005, -1);
    std::cin >> N >> K;
    dist[N] = 0;
    std::queue<int> q;
    q.push(N);
    while(q.size())
    {
        int cur = q.front();
        q.pop();
        if(cur == K)
        {
            cnt++;
            continue;
        }
        for(const auto& iter : {cur-1, cur+1, cur*2})
        {
            if(iter < 0 || iter > 100'000) continue;
            if(dist[iter] == -1) dist[iter] = dist[cur] + 1;
            if(dist[iter] == dist[cur] + 1) q.push(iter);
        }
    }
    std::cout << dist[K] << '\n' << cnt;
    return 0;
}
