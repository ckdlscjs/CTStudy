#include <bits/stdc++.h>
using namespace std;
int A, B;
std::unordered_map<long long int, int> visited;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> A >> B;
    std::queue<long long int> q;
    visited[A] = 1;
    q.push(A);
    while(q.size() && visited.find(B) == visited.end())
    {
        long long int cur = q.front();
        q.pop();
        for(const auto& iter : {cur * 2, cur*10 + 1})
        {
            if(iter > 1e9) continue;
            if(visited.find(iter) != visited.end()) continue;
            q.push(iter);
            visited[iter] = visited[cur] + 1;
        }
    }
    if(visited.find(B) != visited.end())
        std::cout << visited[B];
    else
        std::cout << -1;
    return 0;
}
