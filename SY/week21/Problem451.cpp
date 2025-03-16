/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>
std::vector<int> alp(26, -1);
char str[105];
int main()
{
    std::cin >> str;
    for(int i = 0; i < strlen(str); i++) if(alp[str[i]-'a'] == -1) alp[str[i]-'a'] = i;
    for(const auto& iter : alp) std::cout << iter << ' ';
    return 0;
}