#include <bits/stdc++.h>
using namespace std;
int N, K, dist[100'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> K;
    std::fill_n(dist, 100'005, 100'005);
    std::queue<int> q;
    q.push(N);
    dist[N] = 0;
    while(q.size())
    {
        int cur = q.front();
        q.pop();
        if(cur*2 <= 100'000 && dist[cur] < dist[cur*2] )
        {
            q.push(cur*2);
            dist[cur*2] = dist[cur];
        }
        if(cur+1 <= 100'000 && dist[cur]+1 < dist[cur+1])
        {
            q.push(cur+1);
            dist[cur+1] = dist[cur] + 1;
        }
        if(0 <= cur-1 && dist[cur]+1 < dist[cur-1])
        {
            q.push(cur-1);
            dist[cur-1] = dist[cur] + 1;
        }
    }
    std::cout << dist[K];
    return 0;
}
