#include <bits/stdc++.h>
using namespace std;
int N;
char arr[((3 * 1<<10) + 1)][((6 * 1 << 10) + 1)];
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N;
    std::fill_n(&arr[0][0], ((3 * 1<<10) + 1) * ((6 * 1 << 10) + 1), ' ');
    std::function<void(int, int, int)> func = [&](int y, int x, int size)->void 
    {
        if(size <= 3)
        {
            arr[y][x] = '*';
            arr[y+1][x-1] = arr[y+1][x+1] = '*';
            arr[y+2][x-2] = arr[y+2][x-1] = arr[y+2][x] = arr[y+2][x+1] = arr[y+2][x+2] = '*';
            return;
        }
        int next = size / 2;
        func(y, x, next);
        func(y + next, x - next, next);
        func(y + next, x + next, next);
    };
    func(0, N-1, N);
    for(int i = 0; i < N; i++)
    {
        for(int j = 0; j < 2 * N - 1; j++)
        {
            std::cout << arr[i][j];
        }
        std::cout << '\n';
    }
    return 0;
}
