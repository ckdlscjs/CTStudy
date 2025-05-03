#include <bits/stdc++.h>
using namespace std;
int N, M, indegree[32'005], A, B;
std::vector<int> graph[32'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> M;
    for(int m = 0; m < M; m++)
    {
        std::cin >> A >> B;
        graph[A].push_back(B);
        indegree[B]++;
    }
    std::queue<int> q;
    for(int n = 1; n <= N; n++)
        if(indegree[n] == 0)
            q.push(n);
    for(int n = 1; n <= N; n++)
    {
        int cur = q.front(); q.pop();
        std::cout << cur << ' ';
        for(const auto& iter : graph[cur])
        {
            indegree[iter]--;
            if(indegree[iter] <= 0)
                q.push(iter);
        }
    }
    return 0;
}
