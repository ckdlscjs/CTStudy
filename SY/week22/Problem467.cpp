/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
int N;
int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cin >> N;
    if (N == 1) { // 1이면 바로 1 출력
        std::cout << 1;
        return 0;
    }

    int k = ceil((1.0 + sqrt(1.0 + 4.0 * (N - 1) / 3.0)) / 2.0);
    std::cout << k;
    return 0;
}