#include <bits/stdc++.h>
using namespace std;
const int dy[] = {-1, 1, 0, 0};
const int dx[] = {0, 0, -1, 1};
int R, C;
bool alp[26];
char arr[22][22];
std::string str;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> R >> C;
    for(int r = 0; r < R; r++)
    {
        std::cin >> str;
        for(int c = 0; c < C; c++)
        {
            arr[r][c] = str[c];
        }
    }
    std::function<int(int y, int x)> func = [&](int y, int x)->int
    {
        alp[arr[y][x]-'A'] = true;
        int ret = 1;
        for(int dir = 0; dir < 4; dir++)
        {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if(alp[arr[ny][nx]-'A']) continue;
            ret = std::max(ret, func(ny, nx) + 1);
        }
        alp[arr[y][x]-'A'] = false;
        return ret;
    };
    std::cout << func(0, 0);
    return 0;
}
