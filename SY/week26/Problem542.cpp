#include <bits/stdc++.h>
using namespace std;
const int INF = 987654321;
const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};
std::string str;
int N, M, arr[1'005][1'005], dist[2][1'005][1'005];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> M;
    for(int n = 0; n < N; n++)
    {
        std::cin >> str;
        for(int m = 0; m < M; m++)
        {
            arr[n][m] = str[m] - '0';
        }
    }
    std::fill_n(&dist[0][0][0], 2*1005*1005, INF);
    std::queue<std::tuple<int, int, int>> q;
    q.push({0, 0, 0});
    dist[0][0][0] = 1;
    while(q.size())
    {
        auto cur = q.front();
        q.pop();
        int cw = std::get<0>(cur);
        int cy = std::get<1>(cur);
        int cx = std::get<2>(cur);
        for(int dir = 0; dir < 4; dir++)
        {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];
            if(ny < 0 || nx < 0 || ny >= N || nx >= M || dist[cw][ny][nx] != INF) continue;
            if(arr[ny][nx] == 0)
            {
                q.push({cw, ny, nx});
                dist[cw][ny][nx] = dist[cw][cy][cx] + 1;
            }
            else if(arr[ny][nx] == 1)
            {
                if(cw >= 1) continue;
                q.push({cw+1, ny, nx});
                dist[cw+1][ny][nx] = dist[cw][cy][cx] + 1;
            }
        }
    }
    if(dist[0][N-1][M-1] != INF || dist[1][N-1][M-1] != INF)
        std::cout << std::min(dist[0][N-1][M-1], dist[1][N-1][M-1]);
    else
        std::cout << -1;
    return 0;
}
