#include <bits/stdc++.h>
int N, M, arr[105], res = 0;
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cin >> N >> M;
    for(int n = 0; n < N; n++) std::cin >> arr[n];
    std::sort(arr, arr+N);
    for(int i = 0; i < N; i++)
    {
        for(int j = i + 1; j < N; j++)
        {
            int lo = j, hi = N;
            while(lo + 1 < hi)
            {
                int mid = (lo + hi) / 2;
                if(arr[i] + arr[j] + arr[mid] > M) hi = mid;
                else lo = mid;
            }
            if(lo == i || lo == j) continue;
            if(arr[i] + arr[j] + arr[lo] <= M)
                res = std::max(arr[i] + arr[j] + arr[lo], res);
        }
    }
    std::cout << res;
	return 0;
}