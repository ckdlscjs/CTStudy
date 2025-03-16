#include <bits/stdc++.h>
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    double A, B;
    std::cin >> A >> B;
    std::cout << std::setprecision(15) << A / B  + 1e-10;
    return 0;
}