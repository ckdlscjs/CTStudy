/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
int arr[3];
int main()
{
    std::cin >> arr[0] >> arr[1] >> arr[2];
    std::cout << arr[0] + arr[1] - arr[2] << '\n';
    std::string str = std::to_string(arr[0]) + std::to_string(arr[1]);
    std::cout << stoi(str) - arr[2];
    return 0;
}