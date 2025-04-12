#include <bits/stdc++.h>
using namespace std;
int N, u, v, d;
std::vector<std::pair<int, int>> graph[100'005];
std::vector<std::pair<int, int>> BFS(int st)
{
    std::vector<std::pair<int, int>> dists(N+1);
    dists[st] = std::make_pair(st, 0);
    std::queue<int> q;
    q.push(st);
    while(q.size())
    {
        int cur = q.front();
        q.pop();
        for(const auto& iter : graph[cur])
        {
            if(dists[iter.first].first) continue;
            q.push(iter.first);
            dists[iter.first] = std::make_pair(iter.first, dists[cur].second + iter.second);
        }
    }
    std::sort(dists.begin(), dists.end(), [](const std::pair<int, int>& a, const std::pair<int, int>& b) -> bool{
        return a.second > b.second;
    });
    return dists;
}
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int i = 0; i < N; i++)
    {
        std::cin >> u;
        while(std::cin >> v)
        {
            if(v == -1) break;
            std::cin >> d;
            graph[u].push_back({v, d});
        }
    }
    std::cout << BFS(BFS(1)[0].first)[0].second;
    return 0;
}
