#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    int A, B;
    std::cin >> A >> B;
    std::cout << (A > B ? ">" : A == B ? "==" : "<");
    return 0;
}