#include <bits/stdc++.h>
using namespace std;
using pll = std::pair<long long, long long>;
long long N, E, u, v, w, sum, visitcnt;
std::vector<pll> graph[10'005];
std::priority_queue<pll, std::vector<pll>, std::greater<pll>> pq;
bool visited[10'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> E;
    for(int e = 0; e < E; e++)
    {
        std::cin >> u >> v >> w;
        graph[u].push_back({v, w});
        graph[v].push_back({u, w});
    }
    pq.push({0, 1});
    while(pq.size() && visitcnt < N)
    {
        auto cur = pq.top();
        pq.pop();
        if(visited[cur.second]) continue;
        visitcnt++;
        visited[cur.second] = true;
        sum += cur.first;
        for(const auto& iter : graph[cur.second])
        {
            if(visited[iter.first]) continue;
            pq.push({iter.second, iter.first});
        }
    }
    std::cout << sum;
    return 0;
}
