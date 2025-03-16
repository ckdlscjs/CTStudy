/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>

int main()
{
    int A, B;
    while(std::cin >> A >> B)
    {
        if(A == 0 && B == 0) return 0;
        std::cout << A + B << '\n';
    }
    return 0;
}