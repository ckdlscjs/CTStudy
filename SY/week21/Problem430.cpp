#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    int arr[5];
    for(int i = 0; i < 5; i++) std::cin >> arr[i];
    std::cout << (arr[0] * arr[0] + arr[1]*arr[1] + arr[2]*arr[2] + arr[3]*arr[3] + arr[4]*arr[4])%10;
    return 0;
}