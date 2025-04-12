#include <bits/stdc++.h>
using namespace std;
long long A, B, C;
int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    std::cin >> A >> B >> C;
    std::function<long long(long long)> func = [&](long long K) -> long long 
    {
        if(K <= 1) return A % C;
        long long temp = func(K/2);
        temp = (temp* temp) % C;
        if(K % 2)
            temp = (temp* A) % C;
        return temp;
    };
    std::cout << func(B);
    return 0;
}
