#include <bits/stdc++.h>
using namespace std;
int N, M;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> N >> M;
    std::function<void(const int *, int *, int, int, int)> func = [&](const int *nums, int *arr, int idx, int cur, int mask) -> void 
    {
       if(cur >= M)
       {
           for(int i = 0; i < cur; i++) std::cout << arr[i] << ' ';
           std::cout << '\n';
           return;
       }
       for(int i = 0; i < N; i++)
       {
           if(mask & 1 << i) continue;
           arr[cur] = nums[i];
           func(nums, arr, i, cur+1, mask | 1 << i);
       }
    };
    int nums[10],arr[10];
    for(int i = 0; i < N; i++) std::cin >> nums[i];
    std::sort(nums, nums+N);
    func(nums, arr, 0, 0, 0);
    return 0;
}
