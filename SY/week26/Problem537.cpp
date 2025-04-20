#include <bits/stdc++.h>
using namespace std;
int N;
bool board[17][17];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    std::function<bool(int, int)> IsPossible = [](int y, int x)->bool
    {
        for(int i = 0; i < y; i++)
        {
            if(board[i][x]) return false;
            if(x-(y-i) >= 0 && board[i][x-(y-i)]) return false;
            if(x+(y-i) < N && board[i][x+(y-i)]) return false;
        }
        return true;
    };
    std::function<int(int)> func = [&](int y)->int
    {
        int res = 0;
        if(y >= N) return 1;
        for(int j = 0; j < N; j++)
        {
            if(IsPossible(y, j))
            {
                board[y][j] = true;
                res += func(y+1);
                board[y][j] = false;
            }
        }
        return res;
    };
    std::cout << func(0);
    return 0;
}
