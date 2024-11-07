#include <bits/stdc++.h>
int n;
int main(void)
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
    std::cin >> n;
    std::vector<int> arr(n, 0);
    for(int i = 0; i < n; i++)
        std::cin >> arr[i];
    std::stack<int> st;
    std::vector<int> ans(n, -1);
    for(int i = 0; i < n; i++)
    {
        while(st.size() && arr[st.top()] < arr[i])
            ans[st.top()] = arr[i], st.pop();
        st.push(i);
    }
    for(const auto& iter : ans)
        std::cout << iter << ' ';
    return 0;
}