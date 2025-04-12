#include <bits/stdc++.h>
using namespace std;
int N, u, v, parents[100'005];
bool visited[100'005];
std::vector<int> graph[100'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    for(int i = 0; i < N; i++)
    {
        std::cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    std::function<void(int)> dfs = [&](int cur) -> void 
    {
        visited[cur] = true;
        for(const auto& iter : graph[cur])
        {
            if(visited[iter]) continue;
            parents[iter] = cur;
            dfs(iter);
        }
    };
    dfs(1);
    for(int i = 2; i <= N; i++) std::cout << parents[i] << '\n';
    return 0;
}
