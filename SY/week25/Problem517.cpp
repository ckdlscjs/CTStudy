#include <bits/stdc++.h>
using namespace std;
int N, M;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> M;
    std::function<void(int *, int, int)> func = [&](int *arr, int idx, int cur) -> void 
    {
        if(idx > N) return;
        if(cur >= M)
        {
            for(int i = 0; i < M; i++)
                std::cout << arr[i] << ' ';
            std::cout << '\n';
            return;
        }
        arr[cur] = idx + 1;
        func(arr, idx+1, cur+1);
        func(arr, idx+1, cur);
    };
    int arr[10];
    func(arr, 0, 0);
    return 0;
}
