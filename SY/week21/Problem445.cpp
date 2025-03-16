/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
int N, arr[1000005];
std::pair<int, int> trees[4*1000005];
std::pair<int, int> Initialize(int s, int e, int cur)
{
    if(s >= e) return trees[cur] = {arr[s], arr[s]};
    int mid = (s + e) / 2;
    std::pair<int, int> left = Initialize(s, mid, cur*2);
    std::pair<int, int> right = Initialize(mid+1, e, cur*2+1);
    return trees[cur] = {std::min(left.first, right.first), std::max(left.second, right.second)};
}
int main()
{
    std::cin >> N;
    for(int n = 1; n <= N; n++) std::cin >> arr[n];
    Initialize(1, N, 1);
    std::cout << trees[1].first << ' ' << trees[1].second;
    return 0;
}