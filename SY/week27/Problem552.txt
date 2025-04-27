#include <bits/stdc++.h>
using namespace std;
const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};
int N, M, arr[1'005][1'005], area[1'005][1'005], reg = 1;
std::vector<int> regions;
int DFS(int y, int x, int region)
{
    int ret = 1;
    area[y][x] = region;
    for(int dir = 0; dir < 4; dir++)
    {
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        if(ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] || area[ny][nx]) continue;
        ret += DFS(ny, nx, region);
    }
    return ret;
}
std::string str;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> M;
    for(int i = 0; i < N; i++)
    {
        std::cin >> str;
        for(int j = 0; j < M; j++)
        {
            arr[i][j] = str[j] - '0';
        }
    }
    regions.push_back(0);
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < M; j++)
        {
           if(arr[i][j] || area[i][j]) continue;
           regions.push_back(DFS(i, j, reg++));
        }
    }
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < M; j++)
        {
           if(arr[i][j] == 0)
           {
               std::cout << 0;
           }
           else
           {
               int sum = 1;
               std::unordered_set<int> chks;
               for(int dir = 0; dir < 4; dir++)
               {
                   int ny = i + dy[dir];
                   int nx = j + dx[dir];
                   if(ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 1) continue;
                   chks.insert(area[ny][nx]);
               }
               for(const auto& iter : chks)
               {
                   sum += regions[iter];
                   sum %= 10;
               }
               std::cout << sum;
           }
        }
        std::cout << '\n';
    }
    return 0;
}