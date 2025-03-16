/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
int N;
std::string str;
int main()
{
    std::cin >> N >> str;
    int sum = 0;
    for(int n = 0; n < N; n++)
        sum += (str[n] - '0');
    std::cout << sum;
    return 0;
}