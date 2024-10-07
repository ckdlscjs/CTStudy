//https://school.programmers.co.kr/learn/courses/30/lessons/132267
#include <bits/stdc++.h>
using namespace std;

int solution(int a, int b, int n) 
{
    int answer = 0;
    while(n >= a)
    {
        answer += n / a * b;
        n = (n-(n/a)*a) + n/a*b;
    }
    return answer;
}