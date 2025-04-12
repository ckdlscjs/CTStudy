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
       if(cur >= M)
       {
           for(int i = 0; i < cur; i++) std::cout << arr[i] << ' ';
           std::cout << '\n';
           return;
       }
       for(int i = idx; i <= N; i++)
       {
           arr[cur] = i;
           func(arr, i, cur+1);
       }
    };
    int arr[10];
    func(arr, 1, 0);
    return 0;
}
