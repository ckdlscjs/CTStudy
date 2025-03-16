/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <bits/stdc++.h>

int main()
{
    int T;
    scanf("%d", &T);
    for(int t = 0; t < T; t++)
    {
        int A, B;
        scanf("%d %d",&A, &B);
        printf("%d\n", A + B);
    }
    return 0;
}